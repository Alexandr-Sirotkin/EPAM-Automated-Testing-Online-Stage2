package EpamLearn.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

  private static WebDriver driver;

  private Driver() {
  }

  public static WebDriver getDriver() {
    if (null == driver) {
      System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
