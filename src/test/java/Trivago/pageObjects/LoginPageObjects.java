package Trivago.pageObjects;

import Trivago.constants.TestContext;
import org.openqa.selenium.By;

public class LoginPageObjects {

    TestContext testContext;
    public By emailInputField = By.xpath("//input[@id='email']");
    public By invalidEmailErrorMessage = By.cssSelector(".FormFieldErrorMessage_errorHint__tM7Z_");

    public String expectedInvalidEmailErrorMessage = "Voer je volledige e-mailadres in. Bijvoorbeeld: naam@voorbeeld.com";





    public LoginPageObjects(TestContext testContext){
        this.testContext = testContext;
    }

    public void inputInvalidEmail(){
        testContext.driver.findElement(emailInputField).sendKeys("Invalid email");
    }


}
