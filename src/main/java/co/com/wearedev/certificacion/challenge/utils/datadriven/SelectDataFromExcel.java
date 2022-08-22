package co.com.wearedev.certificacion.challenge.utils.datadriven;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import java.util.ArrayList;
import java.util.List;

public class SelectDataFromExcel {

    private String fileName;
    private String sheet;
    private List<List<String>> rows;

    public SelectDataFromExcel(String fileName) {
        this.fileName = fileName;
    }

    public static SelectDataFromExcel withPath(String fileName) {
        return new SelectDataFromExcel(fileName);
    }

    public SelectDataFromExcel andSheet(String sheet) {
        this.sheet = sheet;
        return this;
    }

    /**
     * Método usado para setear las filas que se leen del excel y se adjuntarán al feature
     *
     * @return instancia de la misma clase
     */
    public SelectDataFromExcel returnData() {
        rows = new ArrayList<>();
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(fileName);
            Recordset recordset = connection.executeQuery("Select * from " + sheet);

            List<String> columns = recordset.getFieldNames();
            List<String> rowTemp;

            rows.add(columns);

            while (recordset.next()) {
                rowTemp = new ArrayList<>();
                for (int i = 0; i < columns.size(); i++) {
                    rowTemp.add(recordset.getField(i).value());
                }
                rows.add(rowTemp);
            }

            recordset.close();
            connection.close();

        } catch (FilloException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Método usado para formatear un string como se requere adjuntarlo al feature
     *
     * @return el string formateado
     */
    public String formatingToString() {
        StringBuilder temp = new StringBuilder("|");
        for (List<String> row : rows) {
            for (String field : row) {
                temp.append(field).append("|");
            }

            temp.append("\n|");
        }

        return temp.substring(0, temp.length() - 1);
    }
}