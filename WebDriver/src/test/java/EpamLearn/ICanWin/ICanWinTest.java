package EpamLearn.ICanWin;

import EpamLearn.Service.ServicePastebin;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ICanWinTest {

  private final String EXPECTED_HEADING = "Optional Paste Settings";
  ServicePastebin service = new ServicePastebin();

  @BeforeTest
  public void fillOutFormPastebin() {
    service
        .openPastebinPage()
        .fillOutFormForICanWin();
  }

  @Test
  public void checkHeading() {
    Assert.assertEquals(service.getHeadingForICanWin(), EXPECTED_HEADING,
        "Заголовок не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }

}
