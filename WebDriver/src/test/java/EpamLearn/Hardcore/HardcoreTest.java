package EpamLearn.Hardcore;

import EpamLearn.HurtMePlentyAndHardcore.EstimatePage;
import EpamLearn.HurtMePlentyAndHardcore.MailPage;
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
    Double cost = EstimatePage.cost;
    Double price = MailPage.price;
    Assert.assertEquals(price, cost, "Цена в письме не соответствует цене на сайте.");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }

}
