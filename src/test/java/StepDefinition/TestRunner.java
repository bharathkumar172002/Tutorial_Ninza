package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefinition"},
    tags= "@Smoke",
    plugin = {
        "pretty",
        "html:target/htmlreports/report2.html",
        "json:target/jsonreports/report1.json",
        "junit:target/junitreports/report1.junit"
    }
)
public class TestRunner {
}
