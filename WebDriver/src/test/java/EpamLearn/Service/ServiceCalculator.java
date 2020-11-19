package EpamLearn.Service;

import EpamLearn.Driver.Driver;
import EpamLearn.HurtMePlentyAndHardcore.CloudGooglePage;
import EpamLearn.HurtMePlentyAndHardcore.EmailEstimateFormPage;
import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.HurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import EpamLearn.HurtMePlentyAndHardcore.MailPage;
import EpamLearn.HurtMePlentyAndHardcore.SearchResultsForGoogleCloudPage;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ServiceCalculator {

  private WebDriver driver = Driver.getDriver();
  private GoogleCloudPricingCalculatorPage calculator;
  private MailPage mPage;
  private EstimatePage estimatePage;
  private String mailHandle;
  public Double costFromEstimatePage;
  public Double costFromMailPage;

  public ServiceCalculator openCalculatorPage() {
    CloudGooglePage page = new CloudGooglePage(driver);
    page.openPage();
    String request = "Google Cloud Platform Pricing Calculator";
    SearchResultsForGoogleCloudPage pageSearch = page.findRequest(request);
    calculator = pageSearch.selectResult();
    return this;
  }

  public ServiceCalculator fillOutTheCalculatorForm() {
    String numberOfInstances = "4";
    calculator
        .goInTheFrame()
        .selectComputeEngine()
        .setNumberOfInstances(numberOfInstances)
        .setSoftware()
        .setMachineClass()
        .setSeries()
        .setMachineType()
        .selectAddGPUs()
        .setLocalSSD()
        .setDatacenterLocation()
        .setCommitedUsage();
    return this;
  }

  public ServiceCalculator getAnEstimate() {
    estimatePage = calculator.getEstimate();
    costFromEstimatePage = estimatePage.getCost();
    return this;
  }

  public ServiceCalculator openMailPageAndGetEmailAddress() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
    String estimateHandle = String.valueOf(tabList.get(0));
    mailHandle = String.valueOf(tabList.get(1));
    driver.switchTo().window(mailHandle);
    mPage = new MailPage(driver);
    mPage
        .openPage()
        .getMailAddress();
    driver.switchTo().window(estimateHandle);
    return this;
  }

  public ServiceCalculator sendEstimateByMail() {
    EmailEstimateFormPage formPage = estimatePage.sendByEmail();
    formPage.setEmail();
    formPage.sendEmail();
    return this;
  }

  public void acceptLetterAndGetEstimate() {
    driver.switchTo().window(mailHandle);
    mPage.openLetter();
    costFromMailPage = mPage.getCost();
  }

}
