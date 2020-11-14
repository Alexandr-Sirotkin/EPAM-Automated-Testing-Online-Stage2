package EpamLearn.HurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorPage extends Page {

  private static final String NUMBER_OF_INSTANCES = "4";
  private static final String ID_IFRAME = "myFrame";

  @FindBy(xpath = "//md-tab-item/div[@title=\"Compute Engine\"]")
  private WebElement computeEngine;
  @FindBy(xpath = "//input[@ng-model=\"listingCtrl.computeServer.quantity\"]")
  private WebElement numberOfInstances;
  @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.os\"]")
  private WebElement software;
  @FindBy(xpath = "//md-option[@value=\"free\"]")
  private WebElement softwareFree;
  @FindBy(xpath = "//md-select[@placeholder=\"VM Class\"]")
  private WebElement machineClass;
  @FindBy(xpath = "//md-select-menu[@style] /descendant::md-option[@value='regular']")
  private WebElement machineClassRegular;
  @FindBy(xpath = "//md-select[@placeholder=\"Series\"]")
  private WebElement series;
  @FindBy(xpath = "//md-option[@value=\"n1\"]")
  private WebElement seriesN1;
  @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
  private WebElement machineType;
  @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]")
  private WebElement machineTypeN1Standard8;
  @FindBy(xpath = "//md-checkbox[@ng-model=\"listingCtrl.computeServer.addGPUs\"]/div[@class=\"md-container md-ink-ripple\"]")
  private WebElement addGPUs;
  @FindBy(xpath = "//md-select[@placeholder=\"Number of GPUs\"]")
  private WebElement numberOfGPUs;
  @FindBy(xpath = "//md-select-menu[@style]//md-option[@value=\"1\"]")
  private WebElement numberOfGPUs1;
  @FindBy(xpath = "//md-select[@placeholder=\"GPU type\"]")
  private WebElement typeOfGPU;
  @FindBy(xpath = "//md-option[@value=\"NVIDIA_TESLA_V100\"]")
  private WebElement typeOfGPUnvidiaTeslaV100;
  @FindBy(xpath = "//div[@class=\"ng-scope layout-row\"]//md-select[@placeholder=\"Local SSD\"]")
  private WebElement localSSD;
  @FindBy(xpath = "//div[normalize-space()=\"2x375 GB\"]/parent::md-option")
  private WebElement localSSD2x375Gb;
  @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.location\"]")
  private WebElement datacenterLocation;
  @FindBy(xpath = "//md-select-menu[@class=\"md-overflow\"]//md-option[@value=\"europe-west3\"]")
  private WebElement datacenterLocationFrankfurt;
  @FindBy(xpath = "//md-select[@ng-change=\"listingCtrl.onCudChange();\"]")
  private WebElement commitedUsage;
  @FindBy(xpath = "//div[@class=\"md-select-menu-container md-active md-clickable\"]//md-option[@ng-value=\"1\"]")
  private WebElement commitedUsage1Year;
  @FindBy(xpath = "//button[@ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]")
  private WebElement AddToEstimate;


  public GoogleCloudPricingCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudPricingCalculatorPage goInTheFrame() {
    driver.switchTo().frame(0);
    driver.switchTo().frame(ID_IFRAME);
    return this;
  }

  public GoogleCloudPricingCalculatorPage selectComputeEngine() {
    waitVisibilityOf(computeEngine).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setNumberOfInstances() {
    waitVisibilityOf(numberOfInstances).sendKeys(NUMBER_OF_INSTANCES);
    return this;
  }

  public GoogleCloudPricingCalculatorPage setSoftware() {
    waitVisibilityOf(software).click();
    waitVisibilityOf(softwareFree).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setMachineClass() {
    waitVisibilityOf(machineClass).click();
    waitVisibilityOf(machineClassRegular).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setSeries() {
    waitVisibilityOf(series).click();
    waitVisibilityOf(seriesN1).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setMachineType() {
    waitVisibilityOf(machineType).click();
    waitVisibilityOf(machineTypeN1Standard8).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage selectAddGPUs() {
    waitVisibilityOf(addGPUs).click();
    waitVisibilityOf(numberOfGPUs).click();
    waitVisibilityOf(numberOfGPUs1).click();
    waitVisibilityOf(typeOfGPU).click();
    waitVisibilityOf(typeOfGPUnvidiaTeslaV100).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setLocalSSD() {
    waitVisibilityOf(localSSD).click();
    waitVisibilityOf(localSSD2x375Gb).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setDatacenterLocation() {
    waitVisibilityOf(datacenterLocation).click();
    waitVisibilityOf(datacenterLocationFrankfurt).click();
    return this;
  }

  public GoogleCloudPricingCalculatorPage setCommitedUsage() {
    waitVisibilityOf(commitedUsage).click();
    waitVisibilityOf(commitedUsage1Year).click();
    return this;
  }

  public EstimatePage getEstimate() {
    waitVisibilityOf(AddToEstimate).click();
    return new EstimatePage(driver);
  }



}


