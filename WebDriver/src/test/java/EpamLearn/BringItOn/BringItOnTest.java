package EpamLearn.BringItOn;

import EpamLearn.Driver.Driver;
import EpamLearn.ICanWinAndBringItOn.NewPastePastebinPage;
import EpamLearn.Service.ServicePastebin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {

  private ServicePastebin service = new ServicePastebin();
  private WebDriver driver = Driver.getDriver();
  private NewPastePastebinPage newPastePastebinPage = new NewPastePastebinPage(driver);

  @BeforeTest
  public void fillOutFormPastebin() {
    service
        .openPastebinPage()
        .fillOutFormForBringItOn();
  }

  @Test
  public void checkPageTitle() {
    String heading = newPastePastebinPage.getHeading();
    Assert.assertEquals(heading, "how to gain dominance among developers", "Заголовок не соответствует ожидаемому");
  }

  @Test
  public void syntaxHighlightingIsCorrectTest() {
    String textSyntaxHighlighting = newPastePastebinPage.getSyntaxHighlighting();
    Assert.assertEquals(textSyntaxHighlighting, "Bash",
        "Подсветка синтаксиса не соответствует ожидаемой");
  }

  @Test
  public void pasteCodeIsCorrect() {
    String expectedCode = "git config --global user.name  \"New Sheriff in Town\"\n"
        + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
        + "git push origin master --force";
    String code = newPastePastebinPage.getTheCode();
    Assert.assertEquals(code, expectedCode, "Код не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    Driver.closeDriver();
  }
}
