package EpamLearn.ICanWinAndBringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPastePastebinPage extends Page {

  @FindBy(xpath = "//h1")
  private WebElement heading;
  @FindBy(xpath = "//a[text()='Bash']")
  private WebElement syntaxHighlightingBashEnabled;
  @FindBy(xpath = "//ol")
  private WebElement code;

  public NewPastePastebinPage(WebDriver driver) {
    super(driver);
  }

  public String getHeading() {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(heading)).getText();
  }

  public String getSyntaxHighlighting() {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(syntaxHighlightingBashEnabled)).getText();
  }

  public String getTheCode() {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(code)).getText();
  }
}
