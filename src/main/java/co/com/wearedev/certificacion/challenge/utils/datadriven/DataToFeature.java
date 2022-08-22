package co.com.wearedev.certificacion.challenge.utils.datadriven;

import co.com.wearedev.certificacion.challenge.exceptions.FileParametersException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataToFeature {
    private static boolean lineIsAfterExternalData = false;

    private DataToFeature() {
        // esperando implementacion
    }

    /**
     * Lista de todos los features con sus respectivos archivo de excel que se usarán en la prueba
     *
     * @param folder Carpeta donde estarán los archivo .feature
     * @return List<String>
     */
    private static List<String> listOfFeatureFiles(String folder) {
        List<String> listOfFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(folder))) {
            listOfFiles = walk.map(Path::toString)
                    .filter(f -> f.endsWith(".feature")).collect(Collectors.toList());
        } catch (IOException e) {
            Logger.getLogger("").info("Error to read the file");
        }
        return listOfFiles;
    }

    public static String fileFormatedWithScenariosInExcel(String fileNameFeature) {
        StringBuilder dataFeature = new StringBuilder();
        try (FileReader reader = new FileReader(fileNameFeature);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                String temp = readExternalData(line);
                if (temp != null) {
                    dataFeature.append(temp);
                }
            }

        } catch (IOException e) {
            Logger.getLogger("").info("ERROR: " + e);
        }
        dataFeature.deleteCharAt(dataFeature.length() - 1);

        return dataFeature.toString();
    }

    public static String readExternalData(String line) {
        String dataExcel = "";

        if (lineIsAfterExternalData && line.trim().startsWith("|")) {
            return null;
        }

        if (lineIsAfterExternalData && !line.trim().startsWith("|")) {
            lineIsAfterExternalData = false;
        }

        if (line.contains("##@externaldata@")) {
            lineIsAfterExternalData = true;

            List<String> parameters = Arrays.asList(line.split("@"));

            validateSizeOfParameters(parameters);
            String fileName = parameters.get(2);
            String nameSheet = parameters.get(3);

            dataExcel = SelectDataFromExcel.withPath(fileName).andSheet(nameSheet).returnData()
                    .formatingToString();

        }
        if (dataExcel.equalsIgnoreCase("")) {
            return line.concat("\n");
        }
        return line + "\n" + dataExcel;
    }

    public static void validateSizeOfParameters(List<String> listParameters) {
        try {
            if (listParameters.size() != 4) {
                throw new FileParametersException(
                        "Error: external data don't have the required parameters");
            }
        } catch (Exception e) {
            Logger.getLogger("").info(e.toString());
        }
    }

    /**
     * Hace una lista con todos los features dependiendo de la ruta asignada
     *
     * @param featuresDirectoryPath Ruta donde se encuentran los features que tendr�n las tablas
     * @throws IOException            the io exception
     * @throws InvalidFormatException the invalid format exception
     * @author bgaona
     */

    public static void overrideFeatureFiles(String featuresDirectoryPath)
            throws IOException {
        List<String> listOfFeatureFiles = listOfFeatureFiles(featuresDirectoryPath);

        for (String featureFile : listOfFeatureFiles) {
            String featureWithExcelData = fileFormatedWithScenariosInExcel(featureFile);

            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(featureFile), StandardCharsets.UTF_8))) {
                writer.write(featureWithExcelData);

            }
        }
    }
}

