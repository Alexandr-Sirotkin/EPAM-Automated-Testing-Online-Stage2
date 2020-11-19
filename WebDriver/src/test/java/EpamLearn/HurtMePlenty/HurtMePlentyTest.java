package EpamLearn.HurtMePlenty;

import EpamLearn.Driver.Driver;
import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.Service.ServiceCalculator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

  private ServiceCalculator service = new ServiceCalculator();
  private WebDriver driver = Driver.getDriver();
  private EstimatePage estimatePage = new EstimatePage(driver);

  @BeforeTest
  public void calculateTheEstimate() {
    service
        .openCalculatorPage()
        .fillOutTheCalculatorForm()
        .getAnEstimate();
  }

  @Test
  public void checkFieldVMClass() {
    String textVMClass = estimatePage.getTextVMClass();
    Assert.assertEquals(textVMClass, "VM class: regular",
        "Текст поля VM Class не соответствует ожидаемому");
  }

  @Test
  public void checkFieldInstanceType() {
    String textInstanceType = estimatePage.getTextInstanceType();
    Assert.assertEquals(textInstanceType, "Instance type: n1-standard-8",
        "Текст поля Instance Type не соответствует ожидаемому");
  }

  @Test
  public void checkFieldRegion() {
    String textRegion = estimatePage.getTextRegion();
    Assert.assertEquals(textRegion, "Region: Frankfurt",
        "Текст поля Region не соответствует ожидаемому");
  }

  @Test
  public void checkFieldLocalSSD() {
    String textLocalSSD = estimatePage.getTextLocalSSD();
    Assert.assertEquals(textLocalSSD, "Total available local SSD space 2x375 GiB",
        "Текст поля Local SSD не соответствует ожидаемому");
  }

  @Test
  public void checkFieldCommitmentTerm() {
    String textCommitmentTerm = estimatePage.getTextCommitmentTerm();
    Assert.assertEquals(textCommitmentTerm, "Commitment term: 1 Year",
        "Текст поля Commitment Term не соответствует ожидаемому");
  }

  @Test
  public void checkFieldTotalEstimatedCost() {
    String textTotalEstimatedCost = estimatePage.getTextTotalEstimatedCostPerMonth();
    Assert.assertEquals(textTotalEstimatedCost, "Total Estimated Cost: USD 1,082.77 per 1 month",
        "Текст поля Total Estimated Cost не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    Driver.closeDriver();
  }

}
