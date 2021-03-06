package EpamLearn.HurtMePlentyAndHardcore;

import EpamLearn.Wait.PageLoadingConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page {

  static String mailAddress;
  private static final String PAGE_URL = "https://10minutemail.com";
  @FindBy(xpath = "//input[@id=\"mail_address\"]")
  private WebElement fieldMailAddress;
  @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
  private WebElement messageFromEstimatePage;
  @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
  private WebElement totalEstimatedCostPerMonth;

  public MailPage(WebDriver driver) {
    super(driver);
  }

  public MailPage openPage() {
    driver.get(PAGE_URL);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(PageLoadingConditions.jQueryAJAXsCompleted());
    return this;
  }

  public MailPage getMailAddress() {
    do {
      mailAddress = waitVisibilityOf(fieldMailAddress).getAttribute("value");
    } while (!(mailAddress.contains("@")));
    return this;
  }

  public MailPage openLetter() {
    waitVisibilityOf(messageFromEstimatePage).click();
    return this;
  }

  public Double getCost() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
        waitVisibilityOf(totalEstimatedCostPerMonth));
    return Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonth).getText().replaceAll("[^0-9.]", ""));
  }

}
