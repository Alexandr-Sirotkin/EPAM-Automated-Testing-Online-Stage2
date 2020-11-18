package EpamLearn.ICanWinAndBringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

  protected WebDriver driver;
  final int WAIT_TIMEOUT_SECONDS = 10;

  protected Page(WebDriver driver) {
    this.driver = driver;
    driver.manage().window().maximize();
    PageFactory.initElements(driver, this);
  }
}
