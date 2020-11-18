package EpamLearn.HurtMePlentyAndHardcore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGooglePage extends Page {

  @FindBy(xpath = "//input[@aria-label=\"Search\"]")
  private WebElement searchField;

  public CloudGooglePage(WebDriver driver) {
    super(driver);
  }

  public CloudGooglePage openPage() {
    driver.get("https://cloud.google.com");
    this.waitVisibilityOf(searchField);
    return this;
  }

  public SearchResultsForGoogleCloudPage findRequest(String request) {
    searchField.click();
    searchField.sendKeys(request);
    searchField.sendKeys(Keys.ENTER);
    return new SearchResultsForGoogleCloudPage(driver);
  }
}
