package Trivago.stepDefinitions.Web;

import Trivago.constants.Page;
import Trivago.constants.TestContext;
import Trivago.pageObjects.MainPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {

    TestContext testContext;
    Page page;
    MainPageObjects mainPageObjects;

    public MainPage(TestContext testContext, Page page,
                    MainPageObjects mainPageObjects){
        this.testContext = testContext;
        this.page = page;
        this.mainPageObjects = mainPageObjects;
    }

    @Given("User navigates to the main page")
    public void user_navigates_to_the_main_page() {
        Assert.assertEquals(page.mainPage, testContext.driver.getCurrentUrl());
    }
    @Then("Cookie pop up notification is shown")
    public void cookie_pop_up_notification_is_shown() {
        WebDriverWait wait = new WebDriverWait(testContext.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageObjects.cookiePopUp));
        mainPageObjects.cookiePopUpIsDisplayed();
    }
    @And("User accepts cookie notification")
    public void userAcceptsCookieNotification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(testContext.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageObjects.cookieAcceptBtn));
        testContext.driver.findElement(mainPageObjects.cookieAcceptBtn).click();
    }
    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        WebDriverWait wait = new WebDriverWait(testContext.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageObjects.inlogBtn));
        testContext.driver.findElement(mainPageObjects.inlogBtn).click();
    }
    @When("User clicks on valuta options")
    public void userClicksOnValutaOptions() {
        testContext.driver.findElement(mainPageObjects.valutaMenu).click();
    }
    @Then("^All valuta options must consist of valutaList$")
    public void allValutaOptionsMustConsistOfValuta() {

        List<WebElement> Options = testContext.driver.findElements(mainPageObjects.listOfMoneyTypes);
        System.out.println("Size: "+Options.size());

        List<String> valutaList = new ArrayList<>();

        //Voor ieder gevonden webelement in list options get text, en add dit naar een arraylist
        for (WebElement element : Options
             ) {
            String i = element.getAttribute("value");
            valutaList.add(i);
        }

        System.out.println("List of website" + valutaList);
        System.out.println("List of database" + mainPageObjects.moneyType);

       //Check of alle waarden van arraylist moneytype in valutalist zitten
        Assert.assertTrue(valutaList.containsAll(mainPageObjects.moneyType));
    }
}
