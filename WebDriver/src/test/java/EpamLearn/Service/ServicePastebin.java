package EpamLearn.Service;

import EpamLearn.Driver.Driver;
import EpamLearn.ICanWinAndBringItOn.PastebinMainPage;
import org.openqa.selenium.WebDriver;

public class ServicePastebin {

  private WebDriver driver = Driver.getDriver();
  private PastebinMainPage pastebinMainPage;

  public void fillOutFormForICanWin() {
    String codeForICanWin = "Hello from WebDriver";
    String nameForICanWin = "helloweb";
    pastebinMainPage
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
    pastebinMainPage
        .openPage()
        .enterTheCode(codeForBringItOn)
        .chooseSyntaxHighlightingBash()
        .choosePasteExpiration10Minutes()
        .insertNameOrTitle(nameForBringItOn)
        .createNewPaste();
  }

  public ServicePastebin openPastebinPage() {
    pastebinMainPage = new PastebinMainPage(driver);
    return this;
  }

}
