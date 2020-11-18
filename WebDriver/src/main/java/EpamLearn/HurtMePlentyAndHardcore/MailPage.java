package EpamLearn.HurtMePlentyAndHardcore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends Page {

  static String mailAddress;
  public static Double price;
  private static final String PAGE_URL = "https://10minutemail.com";
  @FindBy(xpath = "//input[@id=\"mail_address\"]")
  private WebElement fieldMailAddress;
  @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
  private WebElement messageFromEstimatePage;
  @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
  private WebElement totalEstimatedCostPerMonth;

  MailPage(WebDriver driver) {
    super(driver);
  }

  public MailPage openPage() {
    driver.get(PAGE_URL);
    return this;
  }

  public MailPage getMailAddress() {
    do {
      mailAddress = waitVisibilityOf(fieldMailAddress).getAttribute("value");
    } while (!(mailAddress.contains("@")));
    driver.switchTo().window(windowsList.get(0));
    return this;
  }

  public MailPage openLetter() {
    driver.switchTo().window(windowsList.get(1));
    waitVisibilityOf(messageFromEstimatePage).click();
    return this;
  }

  public void getCost() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
        waitVisibilityOf(totalEstimatedCostPerMonth));
    price = Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonth).getText().replaceAll("[^0-9.]", ""));
  }
}
