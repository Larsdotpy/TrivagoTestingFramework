package Trivago;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Web", "src/test/resources/features/Mobile"},
        glue = {"Trivago/stepDefinitions/Web", "Trivago/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cukes.xml",
                "rerun:target/failed_scenarios.txt"},
        tags = "@Web or @Regression")


public class TestRunner {
}
