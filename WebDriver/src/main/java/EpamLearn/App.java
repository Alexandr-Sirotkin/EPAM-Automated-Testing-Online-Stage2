package EpamLearn;

import EpamLearn.HurtMePlentyAndHardcore.CloudGooglePage;
import EpamLearn.HurtMePlentyAndHardcore.EmailEstimateFormPage;
import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.HurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import EpamLearn.HurtMePlentyAndHardcore.MailPage;
import EpamLearn.HurtMePlentyAndHardcore.SearchResultsForGoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    CloudGooglePage page = new CloudGooglePage(driver);
    page.openPage();
    SearchResultsForGoogleCloudPage pageSearch = page.findRequest();
    GoogleCloudPricingCalculatorPage calculator = pageSearch.selectResult();
    calculator
        .goInTheFrame()
        .selectComputeEngine()
        .setNumberOfInstances()
        .setSoftware();
    EstimatePage ePage = calculator
        .setMachineClass()
        .setSeries()
        .setMachineType()
        .selectAddGPUs()
        .setLocalSSD()
        .setDatacenterLocation()
        .setCommitedUsage()
        .getEstimate();
    ePage.getCost();
    System.out.println(EstimatePage.cost);
    MailPage mPage = ePage.openMailPage();
    mPage.openPage();
    mPage.getMailAddress();
    EmailEstimateFormPage formPage = ePage.sendByEmail();
    formPage.setEmail();
    formPage.sendEmail();
    mPage.openLetter();
    mPage.getCost();
    System.out.println(MailPage.price);


//    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
//    driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    CloudGooglePage page = new CloudGooglePage(driver);
//    page.openPage();
//    SearchResultsForGoogleCloudPage pageSearch = page.findRequest();
//    GoogleCloudPricingCalculatorPage calculator = pageSearch.selectResult();
//    calculator
//        .goInTheFrame()
//        .selectComputeEngine()
//        .setNumberOfInstances()
//        .setSoftware()
//        .setMachineClass()
//        .setSeries()
//        .setMachineType()
//        .selectAddGPUs()
//        .setLocalSSD()
//        .setDatacenterLocation()
//        .setCommitedUsage();
//    EstimatePage ePage = calculator.getEstimate();
//    ePage.getCost();
//    MailPage mPage = ePage.openMailPage();
//    mPage.openPage();
//    mPage.getMailAddress();
//    EmailEstimateFormPage formPage = ePage.sendByEmail();
//    formPage.setEmail();
//    formPage.sendEmail();
//    mPage.openLetter();
//    mPage.getCost();




  }
}
