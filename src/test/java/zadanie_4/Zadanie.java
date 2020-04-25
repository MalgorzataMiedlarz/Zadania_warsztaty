package zadanie_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class Zadanie {
    private WebDriver driver;
    private WebElement firstNameInput;
    private WebElement lastNameInput;
    private List<WebElement> gendersRadioButtons;
    private WebElement dateOfBirthPicker;
    private WebElement address;
    private WebElement email;
    private WebElement password;
    private WebElement company;
    private WebElement comment;
    private WebElement submit;
    private Select role;

    String firstNameValue = "Karol";
    String lastNameValue = "Kowalski";
    String dateOfBirthValue = "05/22/2010";
    String addressValue = "Prosta 51";
    String emailValue = "karol.kowalski@mailinator.com";
    String passwordValue = "Pass123";
    String companyValue = "Coders Lab";
    String commentValue = "To jest mój pierwszy automat testowy";

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

        firstNameInput = driver.findElement(By.id("first-name"));
        lastNameInput = driver.findElement(By.id("last-name"));
        gendersRadioButtons = driver.findElements(By.name("gender"));
        dateOfBirthPicker = driver.findElement(By.id("dob"));
        address = driver.findElement(By.id("address"));
        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.id("password"));
        company = driver.findElement(By.id("company"));
        comment = driver.findElement(By.id("comment"));
        submit = driver.findElement(By.id("submit"));
        role = new Select(driver.findElement(By.id("role")));
    }

    @Test
    public void shouldFillForm() {
        getZadanie4Done(firstNameInput, firstNameValue);
        getZadanie4Done(lastNameInput, lastNameValue);
        gendersRadioButtons.get(0).click();
        assertTrue(gendersRadioButtons.get(0).isSelected());
        assertFalse(gendersRadioButtons.get(1).isSelected());
        assertFalse(gendersRadioButtons.get(2).isSelected());
        getZadanie4Done(dateOfBirthPicker, dateOfBirthValue);
        getZadanie4Done(address, addressValue);
        getZadanie4Done(email, emailValue);
        getZadanie4Done(password, passwordValue);
        getZadanie4Done(company, companyValue);
        role.selectByVisibleText("Manager");
        assertNotNull(role);
        getZadanie4Done(comment, commentValue);
        submit.isDisplayed();
        submit.click();
    }


    @After
    @Ignore
    public void tearDown() {
        // Zamknij przeglądarkę
        driver.quit();
    }

    private void getZadanie4Done(WebElement webElement, String fillValue) {
        assertTrue(webElement.isDisplayed());
        System.out.println(webElement.getAttribute("name") + ": " + fillValue);
        webElement.sendKeys(fillValue);
        assertNotNull(webElement);
        assertEquals(webElement.getAttribute("value"), fillValue);
    }
}