package EpamLearn.Service;

import EpamLearn.ICanWinAndBringItOn.PastebinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServicePastebin {

  private WebDriver driver;

  public WebDriver getDriver(){
    return driver;
  }

  public void openBrowser(){
    System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
    driver = new ChromeDriver();
  }

  public void fillOutFormForICanWin() {
    String codeForICanWin = "Hello from WebDriver";
    String nameForICanWin = "helloweb";
    PastebinMainPage.getInstance(driver)
        .openPage()
        .enterTheCode(codeForICanWin)
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle(nameForICanWin);
  }

  public void fillOutFormForBringItOn() {
    String codeForBringItOn = "git config --global user.name  \"New Sheriff in Town\"\n"
        + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
        + "git push origin master --force";
    String nameForBringItOn = "how to gain dominance among developers";
    PastebinMainPage.getInstance(driver)
        .openPage()
        .enterTheCode(codeForBringItOn)
        .chooseSyntaxHighlightingBash()
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle(nameForBringItOn)
        .createNewPaste();
  }

  public ServicePastebin openPastebinPage() {
    openBrowser();
    PastebinMainPage.getInstance(driver);
    return this;
  }

  public void quit() {
    driver.quit();
    driver = null;
  }

}
