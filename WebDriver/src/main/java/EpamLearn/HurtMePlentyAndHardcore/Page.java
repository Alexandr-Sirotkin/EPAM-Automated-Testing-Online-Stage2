package EpamLearn.HurtMePlentyAndHardcore;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

  protected WebDriver driver;
  protected final int WAIT_TIMEOUT_SECONDS = 15;

  protected Page(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  WebElement waitVisibilityOf(WebElement element) {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

}
