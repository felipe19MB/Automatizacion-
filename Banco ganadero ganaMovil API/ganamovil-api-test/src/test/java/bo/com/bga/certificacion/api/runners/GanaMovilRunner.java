package bo.com.bga.certificacion.api.runners;

import bo.com.bga.certificacion.api.utils.excel.BeforeSuite;
import bo.com.bga.certificacion.api.utils.excel.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/",
        tags = "@auto-949",
        glue = {
                "bo.com.bga.certificacion.api.hook",
                "bo.com.bga.certificacion.api.stepdefinitions"
        },
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        publish = true
)
public class GanaMovilRunner {
        @BeforeSuite
        public static void test() throws InvalidFormatException, IOException {
                DataToFeature.overrideFeatureFiles("src/test/resources/features/");
        }
}
