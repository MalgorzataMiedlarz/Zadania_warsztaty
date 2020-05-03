package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private static WebDriver driver;
    @FindBy(name = "address1")
    WebElement addressInput;
    @FindBy(name = "city")
    WebElement cityInput;
    @FindBy(name = "postcode")
    WebElement postcodeInput;
    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        NewAddressPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillUpAddress(String address){
        addressInput.sendKeys(address);
    }
    public void fillUpCity(String city){
        cityInput.sendKeys(city);
    }
    public void fillUpPostalCode(String postCode){
        postcodeInput.sendKeys(postCode);
    }
    public void clickOnSaveButton(){
        saveButton.click();
    }
}
