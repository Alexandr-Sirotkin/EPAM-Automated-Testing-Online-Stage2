package EpamLearn.BringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinMainPageForBringItOn extends Page {

  private String code = "git config --global user.name  \"New Sheriff in Town\"\n"
      + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
      + "git push origin master --force";
  private String name = "how to gain dominance among developers";
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

  public PastebinMainPageForBringItOn(WebDriver driver) {
    super(driver);
  }

  public PastebinMainPageForBringItOn openPage() {
    driver.get(PAGE_URL);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(newPaste));
    return this;
  }

  public PastebinMainPageForBringItOn enterTheCode() {
    newPaste.sendKeys(code);
    return this;
  }

  public PastebinMainPageForBringItOn chooseSyntaxHighlightingBash() {
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
    return new NewPastePastebinPage(driver);
  }

  public PastebinMainPageForBringItOn insertNameOrTitle() {
    pasteNameOrTitle = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(pasteNameOrTitle));
    pasteNameOrTitle.sendKeys(name);
    return this;
  }

  public PastebinMainPageForBringItOn choosePasteExpiration10Minutes() {
    pasteExpiration = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(pasteExpiration));
    pasteExpiration.click();
    pasteExpiration10Minutes.click();
    return this;
  }
}
