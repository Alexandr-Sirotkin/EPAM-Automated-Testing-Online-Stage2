package EpamLearn.Service;

import EpamLearn.BringItOn.NewPastePastebinPage;
import EpamLearn.ICanWin.Pages.PastebinMainPage;
import EpamLearn.BringItOn.PastebinMainPageForBringItOn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServicePastebin {

  private final String PATH_CHROME_DRIVER = "./src/main/java/resources/chromedriver.exe";
  private WebDriver driver;
  private PastebinMainPage page;
  private PastebinMainPageForBringItOn pageForBringItOn;
  private NewPastePastebinPage newPastePage;

  public void openBrowser(){
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  public ServicePastebin openPastebinPage() {
    openBrowser();
    page = new PastebinMainPage(driver);
    return this;
  }

  public void fillOutFormForICanWin() {
    page
        .openPage()
        .enterTheCode()
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle();
  }

  public void fillOutFormForBringItOn() {
    newPastePage = pageForBringItOn
        .openPage()
        .enterTheCode()
        .chooseSyntaxHighlightingBash()
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle()
        .createNewPaste();
  }

  public String getHeadingForICanWin() {
    return page.getHeading();
  }

  public String getHeadingForBringItOn() {
    return newPastePage.getHeading();
  }

  public String getSyntaxHighlighting() {
    return newPastePage.getSyntaxHighlighting();
  }

  public ServicePastebin openPastebinPageForBringItOn() {
    openBrowser();
    pageForBringItOn = new PastebinMainPageForBringItOn(driver);
    return this;
  }

  public String getTheCode() {
    return newPastePage.getTheCode();
  }

  public void quit() {
    driver.quit();
    driver = null;
  }

}
