package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;

import static org.junit.Assert.assertTrue;

public class HotelDominicCreateAccountsSteps extends StepsBase {
    private WebDriver driver;
    private String email;

    @Given("^an open browser with qloapps.coderslab.pl")
    public void anOpenBrowserWithQloappsCoderslabPl() {
        driver = prepateDriver();
        driver.get("https://qloapps.coderslab.pl/pl/");
    }


    @When("^user click on \"Zaloguj sie\" button$")
    public void userClickOnZalogujSieButton() {
        driver.findElement(By.cssSelector("a[class='user_login navigation-link']")).click();
    }

    @And("^User write a email to create account field$")
    public void userWriteAEmailToCreateAccountField() {
        email = mailRandomGenerator();
        driver.findElement(By.id("email_create")).sendKeys(email);
    }

    @And("^user click on create an account button$")
    public void userClickOnCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @And("^user fill a first name field with (.*)$")
    public void userFillAFirstNameFieldWithFirstName(String firstName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
    }

    @And("^user fill a last name field with (.*)$")
    public void userFillALastNameFieldWithLastName(String lastName) {
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }


    @And("^user fill a password field with (.*)$")
    public void userFillAPasswordFieldWithPassword(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);

    }

    @And("^user pick up a date of birth$")
    public void userPickUpADateOfBirth() {
        new Select(driver.findElement(By.id("days"))).selectByIndex(2);
        new Select(driver.findElement(By.id("months"))).selectByIndex(2);
        new Select(driver.findElement(By.id("years"))).selectByIndex(24);
    }

    @And("^user click on register button$")
    public void userClickOnRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("^user should see a confirm of creating account$")
    public void userShouldSeeAConfirmOfCreatingAccount() {
        assertTrue(driver.findElement(By.cssSelector("p[class='alert alert-success']")).isDisplayed());
    }

    private String mailRandomGenerator() {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli() / 1000;
        return "mail" + timeStampMillis + "@test.com";
    }


    @And("^browser should be close$")
    public void browserShouldBeClose() {
        driver.close();
    }
}
