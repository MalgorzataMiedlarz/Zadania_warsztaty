package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchSteps extends StepsBase {
    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        driver = prepateDriver();
        // Przejdź do Google
        driver.get("http://www.google.com");
    }

    @When("a keyword (.*) is entered in (.*) input field")
    public void enterKeyword(String keyword, String keyword2) {
        System.out.println(keyword2);
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
    }

    @Then("the first one should contain (.*)")
    public void theFirstOneShouldContainKeyword(String expectedText) {
        System.out.println(expectedText);
    }

    @And("close browser")
    public void closeBrowser() {
        closeDriver(driver);
    }
}
