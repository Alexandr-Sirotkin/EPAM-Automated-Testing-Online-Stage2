package EpamLearn.HurtMePlenty;

import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.Service.ServiceCalculator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

  private ServiceCalculator service = new ServiceCalculator();

  @BeforeTest
  public void calculateTheEstimate() {
    service
        .openCalculatorPage()
        .fillOutTheCalculatorForm()
        .getAnEstimate();
  }

  @Test
  public void checkFieldVMClass() {
    String textVMClass = EstimatePage.getInstance(service.getDriver()).getTextVMClass();
    Assert.assertEquals(textVMClass, "VM class: regular",
        "Текст поля VM Class не соответствует ожидаемому");
  }

  @Test
  public void checkFieldInstanceType() {
    String textInstanceType = EstimatePage.getInstance(service.getDriver()).getTextInstanceType();
    Assert.assertEquals(textInstanceType, "Instance type: n1-standard-8",
        "Текст поля Instance Type не соответствует ожидаемому");
  }

  @Test
  public void checkFieldRegion() {
    String textRegion = EstimatePage.getInstance(service.getDriver()).getTextRegion();
    Assert.assertEquals(textRegion, "Region: Frankfurt",
        "Текст поля Region не соответствует ожидаемому");
  }

  @Test
  public void checkFieldLocalSSD() {
    String textLocalSSD = EstimatePage.getInstance(service.getDriver()).getTextLocalSSD();
    Assert.assertEquals(textLocalSSD, "Total available local SSD space 2x375 GiB",
        "Текст поля Local SSD не соответствует ожидаемому");
  }

  @Test
  public void checkFieldCommitmentTerm() {
    String textCommitmentTerm = EstimatePage.getInstance(service.getDriver()).getTextCommitmentTerm();
    Assert.assertEquals(textCommitmentTerm, "Commitment term: 1 Year",
        "Текст поля Commitment Term не соответствует ожидаемому");
  }

  @Test
  public void checkFieldTotalEstimatedCost() {
    String textTotalEstimatedCost = EstimatePage.getInstance(service.getDriver()).getTextTotalEstimatedCostPerMonth();
    Assert.assertEquals(textTotalEstimatedCost, "Total Estimated Cost: USD 1,082.77 per 1 month",
        "Текст поля Total Estimated Cost не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }

}
