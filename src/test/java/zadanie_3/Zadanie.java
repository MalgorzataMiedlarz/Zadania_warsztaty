package zadanie_3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    public void fillForm() {
        firstNameInput.isDisplayed();
        System.out.println(firstNameInput.getAttribute("name") + ": " + firstNameValue);
        firstNameInput.sendKeys(firstNameValue);

        System.out.println(lastNameInput.getAttribute("name") + ": " + lastNameValue);
        lastNameInput.isDisplayed();
        lastNameInput.sendKeys(lastNameValue);

        gendersRadioButtons.get(0).click();

        System.out.println(dateOfBirthPicker.getAttribute("name") + ": " + dateOfBirthValue);
        dateOfBirthPicker.isDisplayed();
        dateOfBirthPicker.sendKeys(dateOfBirthValue);

        System.out.println(address.getAttribute("name") + ": " + addressValue);
        address.isDisplayed();
        address.sendKeys(addressValue);

        System.out.println(email.getAttribute("name") + ": " + emailValue);
        email.isDisplayed();
        email.sendKeys(emailValue);

        System.out.println(password.getAttribute("name") + ": " + passwordValue);
        password.isDisplayed();
        password.sendKeys(passwordValue);

        System.out.println(company.getAttribute("name") + ": " + companyValue);
        company.isDisplayed();
        company.sendKeys(companyValue);

        role.selectByVisibleText("Manager");

        System.out.println(comment.getAttribute("name") + ": " + commentValue);
        comment.isDisplayed();
        comment.sendKeys(commentValue);

        submit.isDisplayed();
        submit.click();
    }

    @Test
    public void fillFormV2() {
        System.out.println("Fill form V2");
        getZadanie3Done(firstNameInput, firstNameValue);
        getZadanie3Done(lastNameInput, lastNameValue);
        gendersRadioButtons.get(0).click();
        getZadanie3Done(dateOfBirthPicker, dateOfBirthValue);
        getZadanie3Done(address, addressValue);
        getZadanie3Done(email, emailValue);
        getZadanie3Done(password, passwordValue);
        getZadanie3Done(company, companyValue);
        role.selectByVisibleText("Manager");
        getZadanie3Done(comment, commentValue);
        submit.isDisplayed();
        submit.click();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }

    private void getZadanie3Done(WebElement webElement, String fillValue) {
        webElement.isDisplayed();
        System.out.println(webElement.getAttribute("name") + ": " + fillValue);
        webElement.sendKeys(fillValue);
    }

}
