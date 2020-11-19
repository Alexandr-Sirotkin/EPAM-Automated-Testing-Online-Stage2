package EpamLearn.HurtMePlentyAndHardcore;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimatePage extends Page {

  @FindBy(xpath = "//div[contains(text(), \"VM class:\")]")
  private WebElement vmClass;
  @FindBy(xpath = "//div[contains(text(), \"Instance type:\")]")
  private WebElement instanceType;
  @FindBy(xpath = "//div[contains(text(), \"Region:\")]")
  private WebElement region;
  @FindBy(xpath = "//div[contains(text(), \"Total available local\")]")
  private WebElement localSSD;
  @FindBy(xpath = "//div[contains(text(), \"Commitment term:\")]")
  private WebElement commitmentTerm;
  @FindBy(xpath = "//b[contains(text(), \"Total Estimated Cost:\")]")
  private WebElement totalEstimatedCostPerMonth;
  @FindBy(xpath = "//button[@id=\"email_quote\"]")
  private WebElement emailEstimate;

  public EstimatePage(WebDriver driver) {
    super(driver);
  }

  public String getTextVMClass() {
    return waitVisibilityOf(vmClass).getText();
  }

  public String getTextInstanceType() {
    return waitVisibilityOf(instanceType).getText();
  }

  public String getTextRegion() {
    return waitVisibilityOf(region).getText();
  }

  public String getTextLocalSSD() {
    return waitVisibilityOf(localSSD).getText();
  }

  public String getTextCommitmentTerm() {
    return waitVisibilityOf(commitmentTerm).getText();
  }

  public String getTextTotalEstimatedCostPerMonth() {
    return waitVisibilityOf(totalEstimatedCostPerMonth).getText();
  }

  public EmailEstimateFormPage sendByEmail() {
    driver.switchTo().frame(0);
    driver.switchTo().frame("myFrame");
    waitVisibilityOf(emailEstimate).click();
    return new EmailEstimateFormPage(driver);
  }

  public Double getCost() {
    return Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonth).getText().replace(" 1 ", "")
            .replaceAll("[^0-9.]", ""));
  }

}
