package EpamLearn.Service;

import EpamLearn.HurtMePlentyAndHardcore.CloudGooglePage;
import EpamLearn.HurtMePlentyAndHardcore.EmailEstimateFormPage;
import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.HurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import EpamLearn.HurtMePlentyAndHardcore.MailPage;
import EpamLearn.HurtMePlentyAndHardcore.SearchResultsForGoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceCalculator {

  private WebDriver driver;
  private GoogleCloudPricingCalculatorPage calculator;
  private MailPage mPage;

  public WebDriver getDriver(){
    return driver;
  }

  public ServiceCalculator openCalculatorPage() {
    String pathChromeDriver = "./src/main/java/resources/chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", pathChromeDriver);
    String request = "Google Cloud Platform Pricing Calculator";
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    CloudGooglePage page = new CloudGooglePage(driver);
    page.openPage();
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
    calculator.getEstimate();
    EstimatePage.getInstance(driver).getCost();
    return this;
  }

  public ServiceCalculator openMailPageAndGetEmailAddress() {
    mPage = EstimatePage.getInstance(driver).openMailPage();
    mPage.openPage();
    mPage.getMailAddress();
    return this;
  }

  public ServiceCalculator sendEstimateByMail() {
    EmailEstimateFormPage formPage = EstimatePage.getInstance(driver).sendByEmail();
    formPage.setEmail();
    formPage.sendEmail();
    return this;
  }

  public ServiceCalculator acceptLetterAndGetEstimate() {
    mPage.openLetter();
    mPage.getCost();
    return this;
  }

  public void quit() {
    driver.quit();
    driver = null;
  }
}
