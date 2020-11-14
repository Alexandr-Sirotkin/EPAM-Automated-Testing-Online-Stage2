package EpamLearn.BringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {


  private NewPastePastebinPage newPastePage;
  private final String PATH_CHROME_DRIVER = "./src/main/java/resources/chromedriver.exe";
  private final String EXPECTED_HEADING = "how to gain dominance among developers";
  private final String EXPECTED_TEXT_SYNTAX_HIGHLIGHTING = "Bash";
  private final String EXPECTED_CODE = "git config --global user.name  \"New Sheriff in Town\"\n"
      + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
      + "git push origin master --force";
  private WebDriver driver;

  @BeforeTest(alwaysRun = true)
  public void openPastebinPage() {
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    PastebinMainPage mainPage = new PastebinMainPage(driver);
    newPastePage = mainPage
        .openPage()
        .enterTheCode()
        .chooseSyntaxHighlightingBash()
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle()
        .createNewPaste();
  }

  @Test
  public void checkPageTitle() {
    String heading = newPastePage.getHeading();
    Assert.assertEquals(heading, EXPECTED_HEADING, "Заголовок не соответствует ожидаемому");
  }


  @Test
  public void syntaxHighlightingIsCorrectTest(){
    String textSyntaxHighlighting = newPastePage.getSyntaxHighlighting();
    Assert.assertEquals(textSyntaxHighlighting, EXPECTED_TEXT_SYNTAX_HIGHLIGHTING, "Подсветка синтаксиса не соответствует ожидаемой");
  }

  @Test
  public void pasteCodeIsCorrect(){
    String code = newPastePage.getTheCode();
    Assert.assertEquals(code, EXPECTED_CODE, "Код не соответствует ожидаемому");
  }

  @AfterTest(alwaysRun = true)
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }

}
