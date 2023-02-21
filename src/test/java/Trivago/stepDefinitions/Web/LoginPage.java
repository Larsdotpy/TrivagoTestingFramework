package Trivago.stepDefinitions.Web;

import Trivago.constants.TestContext;
import Trivago.pageObjects.LoginPageObjects;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;

public class LoginPage {

    TestContext testContext;
    LoginPageObjects loginPageObjects;

    public LoginPage(TestContext testContext, LoginPageObjects loginPageObjects){
        this.testContext = testContext;
        this.loginPageObjects = loginPageObjects;
    }

    @When("User enters an invalid email")
    public void user_enters_an_invalid_email() {
        loginPageObjects.inputInvalidEmail();

        /*Enter knop apart harcoded, omdat je in sommige gevallen de functie van inputInvalidEmail wil behouden
        zonder enter knop erachteraan. Denk aan invalid email + invalid password. Dan je niet hebben dat na het
        invoeren van invalid email gelijk een enter knop volgt. Daarom is het nu gescheiden */

        testContext.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Keys.RETURN);
    }
    @Then("A notification is shown displaying {string} and has {string} hex color value")
    public void aNotificationIsShownDisplayingAndHasHexColorValue(String arg0, String arg1) {
        String invalidEmailErrorMessage = testContext.driver.findElement(loginPageObjects.invalidEmailErrorMessage).getText();
        Assert.assertEquals(loginPageObjects.expectedInvalidEmailErrorMessage, invalidEmailErrorMessage);

        String invalidEmailErrorMessageColor = testContext.driver.findElement(loginPageObjects.invalidEmailErrorMessage).getCssValue("color");
        String invalidEmailErrorMessageHexColor = Color.fromString(invalidEmailErrorMessageColor).asHex();

        Assert.assertEquals("#db3734", invalidEmailErrorMessageHexColor);
    }
}
