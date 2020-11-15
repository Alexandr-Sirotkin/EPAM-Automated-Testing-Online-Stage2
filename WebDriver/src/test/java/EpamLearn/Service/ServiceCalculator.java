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
  private final String PATH_CHROME_DRIVER = "./src/main/java/resources/chromedriver.exe";
  private GoogleCloudPricingCalculatorPage calculator;
  private EstimatePage ePage;
  private MailPage mPage;
  private EmailEstimateFormPage formPage;

  public ServiceCalculator openCalculatorPage() {
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    CloudGooglePage page = new CloudGooglePage(driver);
    page.openPage();
    SearchResultsForGoogleCloudPage pageSearch = page.findRequest();
    calculator = pageSearch.selectResult();
    return this;
  }

  public ServiceCalculator fillOutTheCalculatorForm() {
    calculator
        .goInTheFrame()
        .selectComputeEngine()
        .setNumberOfInstances()
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
    ePage = calculator.getEstimate();
    ePage.getCost();
    return this;
  }

  public ServiceCalculator openMailPageAndGetEmailAddress() {
    mPage = ePage.openMailPage();
    mPage.openPage();
    mPage.getMailAddress();
    return this;
  }

  public ServiceCalculator sendEstimateByMail() {
    formPage = ePage.sendByEmail();
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

  public String getTextVMClass() {
    return ePage.getTextVMClass();
  }

  public String getTextInstanceType() {
    return ePage.getTextInstanceType();
  }

  public String getTextRegion() {
    return ePage.getTextRegion();
  }

  public String getTextLocalSSD() {
    return ePage.getTextLocalSSD();
  }

  public String getTextCommitmentTerm() {
    return ePage.getTextCommitmentTerm();
  }

  public String getTextTotalEstimatedCostPerMonth() {
    return ePage.getTextTotalEstimatedCostPerMonth();
  }

}
