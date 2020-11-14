package EpamLearn.ICanWin;

import EpamLearn.ICanWin.Pages.PastebinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ICanWinTest {

  private final String PATH_CHROME_DRIVER = "./src/main/java/resources/chromedriver.exe";
  private final String EXPECTED_HEADING = "Optional Paste Settings";
  private WebDriver driver;

  @BeforeTest(alwaysRun = true)
  public void openBrowser() {
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void pasteInPastebin() {
    PastebinMainPage page = new PastebinMainPage(driver)
        .openPage()
        .enterTheCode()
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle();
    Assert.assertEquals(page.getHeading(), EXPECTED_HEADING, "Заголовок не соответствует ожидаемому");

  }

  @AfterTest(alwaysRun = true)
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }

}
