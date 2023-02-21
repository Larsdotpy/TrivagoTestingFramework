package Trivago;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/failed_scenarios.txt"},
        glue = {"Trivago/stepDefinitions/Web", "Trivago/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cukes.xml"})


public class FailedScenariosTestRunner {
}
