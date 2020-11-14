package EpamLearn.HurtMePlenty;

import EpamLearn.HurtMePlentyAndHardcore.CloudGooglePage;
import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.HurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import EpamLearn.HurtMePlentyAndHardcore.SearchResultsForGoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

  private WebDriver driver;
  private final String PATH_CHROME_DRIVER = "./src/main/java/resources/chromedriver.exe";
  private final String EXPECTED_TEXT_VM_CLASS = "VM class: regular";
  private final String EXPECTED_TEXT_INSTANCE_TYPE = "Instance type: n1-standard-8";
  private final String EXPECTED_TEXT_REGION = "Region: Frankfurt";
  private final String EXPECTED_TEXT_LOCAL_SSD = "Total available local SSD space 2x375 GiB";
  private final String EXPECTED_TEXT_COMMITMENT_TERM = "Commitment term: 1 Year";
  private final String EXPECTED_TEXT_TOTAL_ESTIMATED_COST = "Total Estimated Cost: USD 1,082.77 per 1 month";
  private EstimatePage estimatePage;

  @BeforeTest
  public void calculateTheEstimate(){
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    CloudGooglePage cloudGooglePage = new CloudGooglePage(driver);
    cloudGooglePage.openPage();
    SearchResultsForGoogleCloudPage pageSearch = cloudGooglePage.findRequest();
    GoogleCloudPricingCalculatorPage calculatorPage = pageSearch.selectResult();
    estimatePage = calculatorPage
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
        .setCommitedUsage()
        .getEstimate();
  }

  @Test
  public void checkFieldVMClass() {
    String textVMClass = estimatePage.getTextVMClass();
    Assert.assertEquals(textVMClass, EXPECTED_TEXT_VM_CLASS, "Текст поля VM Class не соответствует ожидаемому");
  }

  @Test
  public void checkFieldInstanceType() {
    String textInstanceType = estimatePage.getTextInstanceType();
    Assert.assertEquals(textInstanceType, EXPECTED_TEXT_INSTANCE_TYPE, "Текст поля Instance Type не соответствует ожидаемому");
  }

  @Test
  public void checkFieldRegion() {
    String textRegion = estimatePage.getTextRegion();
    Assert.assertEquals(textRegion, EXPECTED_TEXT_REGION, "Текст поля Region не соответствует ожидаемому");
  }

  @Test
  public void checkFieldLocalSSD() {
    String textLocalSSD = estimatePage.getTextLocalSSD();
    Assert.assertEquals(textLocalSSD, EXPECTED_TEXT_LOCAL_SSD, "Текст поля Local SSD не соответствует ожидаемому");
  }

  @Test
  public void checkFieldCommitmentTerm() {
    String textCommitmentTerm = estimatePage.getTextCommitmentTerm();
    Assert.assertEquals(textCommitmentTerm, EXPECTED_TEXT_COMMITMENT_TERM, "Текст поля Commitment Term не соответствует ожидаемому");
  }

  @Test
  public void checkFieldTotalEstimatedCost() {
    String textTotalEstimatedCost = estimatePage.getTextTotalEstimatedCostPerMonth();
    Assert.assertEquals(textTotalEstimatedCost, EXPECTED_TEXT_TOTAL_ESTIMATED_COST, "Текст поля Total Estimated Cost не соответствует ожидаемому");
  }

  @AfterTest(alwaysRun = true)
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }


}
