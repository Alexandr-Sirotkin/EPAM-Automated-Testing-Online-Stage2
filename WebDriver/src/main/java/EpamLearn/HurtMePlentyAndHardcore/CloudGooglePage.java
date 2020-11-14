package EpamLearn.HurtMePlentyAndHardcore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGooglePage extends Page {

  private static final String PAGE_URL = "https://cloud.google.com";
  private static final String REQUEST = "Google Cloud Platform Pricing Calculator";

  @FindBy(xpath = "//input[@aria-label=\"Search\"]")
  private WebElement searchField;

  public CloudGooglePage(WebDriver driver) {
    super(driver);
  }

  public CloudGooglePage openPage() {
    driver.get(PAGE_URL);
    this.waitVisibilityOf(searchField);
    return this;
  }

  public SearchResultsForGoogleCloudPage findRequest() {
    searchField.click();
    searchField.sendKeys(REQUEST);
    searchField.sendKeys(Keys.ENTER);
    return new SearchResultsForGoogleCloudPage(driver);
  }


}
