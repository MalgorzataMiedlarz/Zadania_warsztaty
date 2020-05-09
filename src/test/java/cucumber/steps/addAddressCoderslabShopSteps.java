package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class addAddressCoderslabShopSteps {
    private WebDriver driver;

    @Given("an open browser with prod-kurs.coderslab.pl logged as a user")
    public void openProdKursCodersLabAndLogIn() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");

        WebElement signIn = driver.findElement(By.cssSelector(".user-info > a:nth-child(1)"));
        signIn.click();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("wdvzwjwvutxdizsxun@ttirv.com");

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("haslo1");
        pass.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user goes to your address site")
    public void goToYourAddress() {
        WebElement addressSite = driver.findElement(By.cssSelector("#addresses-link"));
        addressSite.click();
    }

    @And("^click on 'Create new address' button$")
    public void clickOnCreateNewAddressButton() {
        WebElement clickOnCreateNewAddressButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/a"));
        clickOnCreateNewAddressButton.click();
    }

    @And("an alias (.*)is entered in alias input field")
    public void aliasInput(String alias) {
        WebElement aliasIn = driver.findElement(By.name("alias"));
        aliasIn.sendKeys(alias);
        assertEquals("dom ",alias);
    }

    @And("an (.*) is entered in address input field")
    public void anAddressIsEnteredInAddressInputField(String address) {
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
        assertEquals("Koralowa10", address);
    }

    @And("a (.*) is entered in city input field")
    public void aCityIsEnteredInCityInputField(String city) {
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
        assertEquals("Wyzima",city);
    }

    @And("a (.*) is entered in zip/postalcode input field")
    public void aPostalcodeIsEnteredInZipPostalcodeInputField(String postalcode) {
        WebElement postalcodeInput = driver.findElement(By.name("postcode"));
        postalcodeInput.sendKeys(postalcode);
        assertEquals("12-345", postalcode);
    }

    @And("a <country> is chosen from dropdown list")
    public void aCountryIsChosenFromDropdownList() {
        Select countryInput = new Select(driver.findElement(By.name("id_country")));
        countryInput.selectByVisibleText("United Kingdom");
    }

    @And("a (.*) is entered in phone input field")
    public void aPhoneIsEnteredInPhoneInputField(String phone) {
        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys(phone);
        assertEquals("7777", phone);
        phoneInput.submit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement checkIsAddressAdded = driver.findElement(By.xpath("//aside/div/article/ul/li"));
        assertEquals("Address successfully added!", checkIsAddressAdded.getText());

    }

    @Then("^an addres is deleted$")
    public void anAddresIsDeleted() {
        WebElement deleteAddres;
        deleteAddres = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]"));
        deleteAddres.click();

        WebElement checkIsAddressDeleted = driver.findElement(By.xpath("//aside/div/article/ul/li"));
        assertEquals("Address successfully deleted!", checkIsAddressDeleted.getText());

    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.close();
    }


}




