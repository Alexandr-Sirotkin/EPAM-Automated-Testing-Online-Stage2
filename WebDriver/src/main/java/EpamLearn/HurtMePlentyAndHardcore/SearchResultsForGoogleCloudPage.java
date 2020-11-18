package EpamLearn.HurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsForGoogleCloudPage extends Page {

  @FindBy(xpath = "//div[@class=\"gs-title\"]/a[@href=\"https://cloud.google.com/products/calculator\"]")
  private WebElement requiredSearchResult;

  SearchResultsForGoogleCloudPage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudPricingCalculatorPage selectResult() {
    waitVisibilityOf(requiredSearchResult).click();
    return new GoogleCloudPricingCalculatorPage(driver);
  }

}
