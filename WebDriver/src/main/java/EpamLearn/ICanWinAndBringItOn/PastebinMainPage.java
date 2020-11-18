package EpamLearn.ICanWinAndBringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinMainPage extends Page {

  private static PastebinMainPage pastebinMainPage;
  @FindBy(xpath = "//div[@class=\"content__title -paste\"]")
  private WebElement heading;
  @FindBy(xpath = "//textarea[@id=\"postform-text\"]")
  private WebElement newPaste;
  @FindBy(xpath = "//span[@id=\"select2-postform-format-container\"]")
  private WebElement syntaxHighlighting;
  @FindBy(xpath = "//li[contains(@aria-label,\"ALL LANGUAGES\")]//li[text()=\"Bash\"]")
  private WebElement syntaxHighlightingBash;
  @FindBy(xpath = "//span[@id=\"select2-postform-expiration-container\"]")
  private WebElement pasteExpiration;
  @FindBy(xpath = "//li[text()=\"10 Minutes\"]")
  private WebElement pasteExpiration10Minutes;
  @FindBy(xpath = "//input[@id=\"postform-name\"]")
  private WebElement pasteNameOrTitle;
  @FindBy(xpath = "//button[text()=\"Create New Paste\"]")
  private WebElement createNewPasteBtn;
  private static final String PAGE_URL = "https://pastebin.com";

  private PastebinMainPage(WebDriver driver) {
    super(driver);
  }

  public static PastebinMainPage getInstance(WebDriver driver) {
    if (pastebinMainPage == null) {
      pastebinMainPage = new PastebinMainPage(driver);
    }
    return pastebinMainPage;
  }

  public PastebinMainPage openPage() {
    driver.get(PAGE_URL);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(newPaste));
    return this;
  }

  public PastebinMainPage enterTheCode(String code) {
    newPaste.sendKeys(code);
    return this;
  }

  public PastebinMainPage chooseSyntaxHighlightingBash() {
    syntaxHighlighting = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(syntaxHighlighting));
    syntaxHighlighting.click();
    syntaxHighlightingBash.click();
    return this;
  }

  public NewPastePastebinPage createNewPaste() {
    createNewPasteBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(createNewPasteBtn));
    createNewPasteBtn.click();
    return NewPastePastebinPage.getInstance(driver);
  }

  public PastebinMainPage insertNameOrTitle(String name) {
    pasteNameOrTitle = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(pasteNameOrTitle));
    pasteNameOrTitle.sendKeys(name);
    return this;
  }

  public PastebinMainPage choosePasteExpiration10Minutes() {
    pasteExpiration = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(pasteExpiration));
    pasteExpiration.click();
    pasteExpiration10Minutes.click();
    return this;
  }

  public String getHeading() {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(heading)).getText();
  }
}
