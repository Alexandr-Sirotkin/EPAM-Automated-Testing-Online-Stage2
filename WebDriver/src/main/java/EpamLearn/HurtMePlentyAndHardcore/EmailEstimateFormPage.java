package EpamLearn.HurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailEstimateFormPage extends Page {

  @FindBy(xpath = "//input[@type=\"email\"]")
  private WebElement fieldEmail;
  @FindBy(xpath = "//button[@aria-label=\"Send Email\"]")
  private WebElement buttonSendEmail;

  public EmailEstimateFormPage(WebDriver driver) {
    super(driver);
  }

  public EmailEstimateFormPage setEmail() {
    waitVisibilityOf(fieldEmail).sendKeys(MailPage.mailAddress);
    return this;
  }

  public EmailEstimateFormPage sendEmail() {
    waitVisibilityOf(buttonSendEmail).click();
    return this;
  }
}
