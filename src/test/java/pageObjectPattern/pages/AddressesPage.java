package pageObjectPattern.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressesPage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@data-link-action='add-address']")
    WebElement createNewAddressButton;

    @FindBy(xpath = "//*[@id='notifications']/div/article")
    WebElement successInformation;

    public AddressesPage(WebDriver driver) {
        AddressesPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void createNewAddress(){
        createNewAddressButton.click();
    }

    public void isSuccessInformationIsDisplay(){
        Assert.assertTrue(successInformation.isDisplayed());
    }
}
