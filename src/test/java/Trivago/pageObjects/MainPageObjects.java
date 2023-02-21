package Trivago.pageObjects;


import Trivago.constants.TestContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class MainPageObjects {

    TestContext testContext;

    public By cookiePopUp = By.cssSelector("#onetrust-banner-sdk");
    public By cookieAcceptBtn = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    public By inlogBtn = By.xpath("//span[contains(text(),'Inloggen')]");
    public By valutaMenu = By.xpath("//select[@id='currency-selector']");
    public By listOfMoneyTypes = By.xpath("//*[@id=\"currency-selector\"]/optgroup[2]/option");

    public List<String> moneyType = Arrays.asList("AED", "ARS", "AUD", "AZN",
            "BGN", "BHD", "BRL", "CAD", "CHF", "CLP", "CNY", "COP", "CZK", "DKK", "DZD", "EGP",
            "EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR", "JOD", "JPY", "KRW", "KWD", "KZT",
            "LBP", "MAD", "MDL", "MXN", "MYR", "NGN", "NOK", "NZD", "OMR", "PEN", "PHP", "PLN", "QAR", "RON",
            "RSD", "RUB", "SAR", "SEK", "SGD", "THB", "TND", "TRY", "TWD", "UAH", "USD", "UYU", "VND", "ZAR");


    public MainPageObjects(TestContext testContext){
        this.testContext = testContext;
    }

    public void cookiePopUpIsDisplayed(){

        Assert.assertTrue(testContext.driver.findElement(cookiePopUp).isDisplayed());
    }

}
