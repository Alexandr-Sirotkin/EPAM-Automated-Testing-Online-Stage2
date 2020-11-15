package EpamLearn.ICanWin.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinMainPage extends Page {

  private String code = "Hello from WebDriver";
  private String name = "helloweb";
  @FindBy(xpath = "//div[@class=\"content__title -paste\"]")
  private WebElement heading;
  @FindBy(xpath = "//textarea[@id=\"postform-text\"]")
  private WebElement newPaste;
  @FindBy(xpath = "//span[@id=\"select2-postform-expiration-container\"]")
  private WebElement pasteExpiration;
  @FindBy(xpath = "//li[text()=\"10 Minutes\"]")
  private WebElement pasteExpiration10Minutes;
  @FindBy(xpath = "//input[@id=\"postform-name\"]")
  private WebElement pasteNameOrTitle;

  private static final String PAGE_URL = "https://pastebin.com";

  public PastebinMainPage(WebDriver driver) {
    super(driver);
  }

  public PastebinMainPage openPage() {
    driver.get(PAGE_URL);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(newPaste));
    return this;
  }

  public PastebinMainPage enterTheCode() {
    newPaste.sendKeys(code);
    return this;
  }

  public PastebinMainPage choosePasteExpiration10Minutes() {
    pasteExpiration = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(pasteExpiration));
    pasteExpiration.click();
    pasteExpiration10Minutes.click();
    return this;
  }

  public PastebinMainPage insertNameOrTitle() {
    pasteNameOrTitle = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(pasteNameOrTitle));
    pasteNameOrTitle.sendKeys(name);
    return this;
  }

  public String getHeading() {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(heading)).getText();
  }

}
