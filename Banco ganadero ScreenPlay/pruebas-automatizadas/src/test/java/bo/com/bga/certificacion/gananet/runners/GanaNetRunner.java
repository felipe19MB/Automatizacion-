package bo.com.bga.certificacion.gananet.runners;


import bo.com.bga.certificacion.gananet.utils.excel.BeforeSuite;
import bo.com.bga.certificacion.gananet.utils.excel.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        //tags = "@auto-586",
        glue = "bo.com.bga.certificacion.gananet.stepdefinitions",
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        snippets= CucumberOptions.SnippetType.CAMELCASE)
public class GanaNetRunner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features");
    }
}


