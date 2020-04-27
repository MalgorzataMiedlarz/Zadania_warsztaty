package cucumber1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/cucumber1/features", glue = "cucumber1.steps",
        plugin = {"pretty", "html:out"})

public class GoogleSearchTest {
}

