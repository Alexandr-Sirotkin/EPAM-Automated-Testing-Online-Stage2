package EpamLearn.ICanWin;

import EpamLearn.ICanWinAndBringItOn.PastebinMainPage;
import EpamLearn.Service.ServicePastebin;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ICanWinTest {

  ServicePastebin service = new ServicePastebin();

  @BeforeTest
  public void fillOutFormPastebin() {
    service
        .openPastebinPage()
        .fillOutFormForICanWin();
  }

  @Test
  public void checkHeading() {
    Assert.assertEquals(PastebinMainPage.getInstance(service.getDriver()).getHeading(), "Optional Paste Settings",
        "Заголовок не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }
}
