package co.com.wearedev.certificacion.challenge.runners;

import co.com.wearedev.certificacion.challenge.utils.datadriven.BeforeSuite;
import co.com.wearedev.certificacion.challenge.utils.datadriven.DataToFeature;
import co.com.wearedev.certificacion.challenge.utils.datadriven.RunnerPersonalizado;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        glue = "co.com.wearedev.certificacion.challenge.stepdefinitions",
        features = "src/test/resources/features/swag_lab.feature",
        snippets = SnippetType.CAMELCASE
)

public class SwagLab {

    @BeforeSuite
    public static void test() throws IOException {
        DataToFeature.overrideFeatureFiles("src//test//resources//features//swag_lab.feature");
    }
}
