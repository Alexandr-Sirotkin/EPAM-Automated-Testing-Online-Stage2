package EpamLearn.BringItOn;

import EpamLearn.ICanWinAndBringItOn.NewPastePastebinPage;
import EpamLearn.Service.ServicePastebin;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {

  ServicePastebin service = new ServicePastebin();

  @BeforeTest
  public void fillOutFormPastebin() {
    service
        .openPastebinPage()
        .fillOutFormForBringItOn();
  }

  @Test
  public void checkPageTitle() {
    String heading = NewPastePastebinPage.getInstance(service.getDriver()).getHeading();
    Assert.assertEquals(heading, "how to gain dominance among developers", "Заголовок не соответствует ожидаемому");
  }

  @Test
  public void syntaxHighlightingIsCorrectTest() {
    String textSyntaxHighlighting = NewPastePastebinPage.getInstance(service.getDriver()).getSyntaxHighlighting();
    Assert.assertEquals(textSyntaxHighlighting, "Bash",
        "Подсветка синтаксиса не соответствует ожидаемой");
  }

  @Test
  public void pasteCodeIsCorrect() {
    String expectedCode = "git config --global user.name  \"New Sheriff in Town\"\n"
        + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
        + "git push origin master --force";
    String code = NewPastePastebinPage.getInstance(service.getDriver()).getTheCode();
    Assert.assertEquals(code, expectedCode, "Код не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }
}
