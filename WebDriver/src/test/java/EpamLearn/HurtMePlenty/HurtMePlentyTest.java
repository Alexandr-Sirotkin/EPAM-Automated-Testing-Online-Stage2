package EpamLearn.HurtMePlenty;

import EpamLearn.Service.ServiceCalculator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

  private final String EXPECTED_TEXT_VM_CLASS = "VM class: regular";
  private final String EXPECTED_TEXT_INSTANCE_TYPE = "Instance type: n1-standard-8";
  private final String EXPECTED_TEXT_REGION = "Region: Frankfurt";
  private final String EXPECTED_TEXT_LOCAL_SSD = "Total available local SSD space 2x375 GiB";
  private final String EXPECTED_TEXT_COMMITMENT_TERM = "Commitment term: 1 Year";
  private final String EXPECTED_TEXT_TOTAL_ESTIMATED_COST = "Total Estimated Cost: USD 1,082.77 per 1 month";
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
    String textVMClass = service.getTextVMClass();
    Assert.assertEquals(textVMClass, EXPECTED_TEXT_VM_CLASS,
        "Текст поля VM Class не соответствует ожидаемому");
  }

  @Test
  public void checkFieldInstanceType() {
    String textInstanceType = service.getTextInstanceType();
    Assert.assertEquals(textInstanceType, EXPECTED_TEXT_INSTANCE_TYPE,
        "Текст поля Instance Type не соответствует ожидаемому");
  }

  @Test
  public void checkFieldRegion() {
    String textRegion = service.getTextRegion();
    Assert.assertEquals(textRegion, EXPECTED_TEXT_REGION,
        "Текст поля Region не соответствует ожидаемому");
  }

  @Test
  public void checkFieldLocalSSD() {
    String textLocalSSD = service.getTextLocalSSD();
    Assert.assertEquals(textLocalSSD, EXPECTED_TEXT_LOCAL_SSD,
        "Текст поля Local SSD не соответствует ожидаемому");
  }

  @Test
  public void checkFieldCommitmentTerm() {
    String textCommitmentTerm = service.getTextCommitmentTerm();
    Assert.assertEquals(textCommitmentTerm, EXPECTED_TEXT_COMMITMENT_TERM,
        "Текст поля Commitment Term не соответствует ожидаемому");
  }

  @Test
  public void checkFieldTotalEstimatedCost() {
    String textTotalEstimatedCost = service.getTextTotalEstimatedCostPerMonth();
    Assert.assertEquals(textTotalEstimatedCost, EXPECTED_TEXT_TOTAL_ESTIMATED_COST,
        "Текст поля Total Estimated Cost не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }

}
