package Trivago.stepDefinitions;

import Trivago.constants.Page;
import Trivago.constants.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Hooks {

    TestContext testContext;
    Page page;

    public Hooks(TestContext testContext, Page page){
        this.testContext = testContext;
        this.page = page;
    }

    @Before("@Web")
    public void BeforeWebScenario(){
        System.setProperty("webdriver.chrome.driver", "/Users/larsdebruijn/Documents/SeleniumCucumberBDDframework/src/test/java/Trivago/drivers/chromedriver");
        testContext.driver = new ChromeDriver();
        testContext.driver.navigate().to(page.mainPage);
    }

    @After("@Web")
    public void AfterWebScenario(){
        testContext.driver.quit();
    }

    @Before("@Mobile")
    public void BeforeMobileScenario(){
        // code
    }

    @After("@Mobile")
    public void AfterMobileScenario(){
        // code
    }

    @AfterStep("@Web or @Mobile")
    public void addScreenshot(Scenario scenario){

        if(scenario.isFailed()){
            byte[] sourcePath = ((TakesScreenshot)testContext.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", "failedScenarioScreenshot");
        }
    }

}
