package EpamLearn.Hardcore;

import EpamLearn.HurtMePlentyAndHardcore.CloudGooglePage;
import EpamLearn.HurtMePlentyAndHardcore.EmailEstimateFormPage;
import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.HurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import EpamLearn.HurtMePlentyAndHardcore.MailPage;
import EpamLearn.HurtMePlentyAndHardcore.SearchResultsForGoogleCloudPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Service {

  private WebDriver driver;
  private final String PATH_CHROME_DRIVER = "./src/main/java/resources/chromedriver.exe";
  private GoogleCloudPricingCalculatorPage calculator;
  private EstimatePage ePage;
  private MailPage mPage;
  private EmailEstimateFormPage formPage;

  public Service openCalculatorPage() {
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    CloudGooglePage page = new CloudGooglePage(driver);
    page.openPage();
    SearchResultsForGoogleCloudPage pageSearch = page.findRequest();
    calculator = pageSearch.selectResult();
    return this;
  }

  public Service fillOutTheCalculatorForm(){
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

  public Service getAnEstimate() {
    ePage = calculator.getEstimate();
    ePage.getCost();
    return this;
  }

  public Service openMailPageAndGetEmailAddress() {
    mPage = ePage.openMailPage();
    mPage.openPage();
    mPage.getMailAddress();
    return this;
  }

  public Service sendEstimateByMail(){
    formPage = ePage.sendByEmail();
    formPage.setEmail();
    formPage.sendEmail();
    return this;
  }

  public Service acceptLetterAndGetEstimate(){
    mPage.openLetter();
    mPage.getCost();
    return this;
  }

  public void quit(){
    driver.quit();
    driver = null;
  }

}
