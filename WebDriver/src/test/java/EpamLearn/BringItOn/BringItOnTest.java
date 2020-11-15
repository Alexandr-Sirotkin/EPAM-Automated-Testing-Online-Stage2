package EpamLearn.BringItOn;

import EpamLearn.Service.ServicePastebin;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {

  private final String EXPECTED_HEADING = "how to gain dominance among developers";
  private final String EXPECTED_TEXT_SYNTAX_HIGHLIGHTING = "Bash";
  private final String EXPECTED_CODE = "git config --global user.name  \"New Sheriff in Town\"\n"
      + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
      + "git push origin master --force";
  ServicePastebin service = new ServicePastebin();

  @BeforeTest(alwaysRun = true)
  public void fillOutFormPastebin() {
    service
        .openPastebinPageForBringItOn()
        .fillOutFormForBringItOn();
  }

  @Test
  public void checkPageTitle() {
    String heading = service.getHeadingForBringItOn();
    Assert.assertEquals(heading, EXPECTED_HEADING, "Заголовок не соответствует ожидаемому");
  }

  @Test
  public void syntaxHighlightingIsCorrectTest() {
    String textSyntaxHighlighting = service.getSyntaxHighlighting();
    Assert.assertEquals(textSyntaxHighlighting, EXPECTED_TEXT_SYNTAX_HIGHLIGHTING,
        "Подсветка синтаксиса не соответствует ожидаемой");
  }

  @Test
  public void pasteCodeIsCorrect() {
    String code = service.getTheCode();
    Assert.assertEquals(code, EXPECTED_CODE, "Код не соответствует ожидаемому");
  }

  @AfterTest
  public void closeBrowser() {
    service.quit();
  }

}
