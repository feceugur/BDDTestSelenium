package BDDTestCase1.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-html-reports"},
        glue = "BDDTestCase1/step_def",
        features = "src/test/resources/features",
        //tags =
        dryRun = false
)
public class CucumberRunner {
}