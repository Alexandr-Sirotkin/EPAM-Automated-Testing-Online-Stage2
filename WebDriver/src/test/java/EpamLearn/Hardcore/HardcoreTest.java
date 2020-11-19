package EpamLearn.Hardcore;

import EpamLearn.Driver.Driver;
import EpamLearn.Service.ServiceCalculator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardcoreTest {

  private ServiceCalculator service = new ServiceCalculator();

  @BeforeTest
  public void sendAndAcceptEstimate(){
    service
        .openCalculatorPage()
        .fillOutTheCalculatorForm()
        .getAnEstimate()
        .openMailPageAndGetEmailAddress()
        .sendEstimateByMail()
        .acceptLetterAndGetEstimate();
  }

  @Test
  public void comparePrices() {
    Assert.assertEquals(service.costFromMailPage, service.costFromEstimatePage, "Цена в письме не соответствует цене на сайте.");
  }

  @AfterTest
  public void closeBrowser() {
    Driver.closeDriver();
  }

}
