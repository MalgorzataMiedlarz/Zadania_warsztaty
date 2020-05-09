package zadanie_2;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class zadanie_2_warsztaty {
  private WebDriver driver;

  @Before
  public void browserOpenAndLogIn() {
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

    WebDriverWait waitForMyaccount = new WebDriverWait(driver, 10);
    waitForMyaccount.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-account")));
  }

  @Test
  public void buyProcessTest() {
    WebElement clothesCategory = driver.findElement(By.id("category-3"));
    clothesCategory.click();

    WebDriverWait waitForProduct = new WebDriverWait(driver, 10);
    waitForProduct.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/a")));

    WebElement product = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/a"));
    product.click();
    Select sizePicking = new Select(driver.findElement(By.id("group_1")));
    sizePicking.selectByVisibleText("M");

    WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
    quantityInput.click();
    quantityInput.clear();
    quantityInput.sendKeys("5");

    WebElement goToChart = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
    goToChart.click();

    WebDriverWait waitForPopUp = new WebDriverWait(driver, 10);
    waitForPopUp.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));

    WebElement proceedToCheckout = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
    proceedToCheckout.click();

    WebDriverWait waitForChart = new WebDriverWait(driver, 10);
    waitForChart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")));

    WebElement proceedtoCheckoutInChart = driver. findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
    proceedtoCheckoutInChart.click();

    WebDriverWait waitForAddress = new WebDriverWait(driver, 10);
    waitForAddress.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-personal-information-step")));

    WebElement addressConfirm = driver.findElement(By.name("confirm-addresses"));
    addressConfirm.click();

    WebDriverWait waitForDelivery = new WebDriverWait(driver, 10);
    waitForDelivery.until(ExpectedConditions.visibilityOfElementLocated(By.name("confirmDeliveryOption")));

    WebElement confirmDeliveryOption = driver.findElement(By.name("confirmDeliveryOption"));
    confirmDeliveryOption.click();

    WebDriverWait waitForPayment = new WebDriverWait(driver, 10);
    waitForPayment.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/h1")));

    WebElement paymentOptionRB = driver.findElement(By.id("payment-option-1"));
    paymentOptionRB.click();

    WebElement termsOfServiceCB = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
    termsOfServiceCB.click();

    WebElement finalConfirm = driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));
    finalConfirm.click();

    WebDriverWait waitForConfirmation = new WebDriverWait(driver, 10);
    waitForConfirmation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div/section/section[1]/div/div/div")));

    try {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      FileUtils.copyFile(screenshot, new File("/home/gosia/Pulpit/potwierdzanie_zamówienia.png"));

    } catch (Exception e) {
      System.out.println("Failure to take screenshot " + e);
    }
  }
  @Test
  public void orderValidate(){
    WebElement account = driver.findElement(By.className("account"));
    account.click();

    WebDriverWait waitForOrderHistory = new WebDriverWait(driver, 10);
    waitForOrderHistory.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[3]/span")));

    WebElement orderHistory = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[3]/span"));
    orderHistory.click();
  }
  @After
  public void closeBrowser(){
    driver.quit();
  }
}

