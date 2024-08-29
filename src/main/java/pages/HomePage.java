package pages;
 
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import utils.ExtentManager;
import utils.ScreenshotUtil;
 
public class HomePage {
    private AppiumDriver driver;
    By HomeNavTitle = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']");
    By OpenDropdown = By.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]");
    By SelectedCountry = By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]");
    By updateName = By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]");
    By clickTheButton =By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]");
    WebDriverWait wait;
    ExtentReports extent;
    ExtentTest test;
    private ScreenshotUtil screenshotUtil;
    public HomePage(AppiumDriver driver)
    {
        this.driver= driver;
        extent = ExtentManager.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        test = ExtentManager.createTest("App Launch","App is Opening");
        screenshotUtil = new ScreenshotUtil(driver);
    }
 
    public void isHomeScreenTitleDisplayed() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeNavTitle));
            test.pass("App is opened");
            Assert.assertTrue(title.isDisplayed());
            screenshotUtil.takeScreenshotAndAttachToAllure();
        }catch(Exception e) {
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.fail("App is not opened");
        }
    }
 
    public void openCountryDropDown() throws InterruptedException {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(OpenDropdown));
 
            Assert.assertTrue(dropdown.isDisplayed(), "Country dropdown is not displayed");
            test.pass("Opened the country dropdown");
            dropdown.click();
            screenshotUtil.takeScreenshotAndAttachToAllure();
        }catch(Exception e)
        {
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.fail("Country dropdown not opened");
        }
 
    }
    public void selectCountryFromDropDown(String countryName) {
        try {
            By uiScrollable = AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + countryName + "\"))"
                    );
            WebElement country = driver.findElement(uiScrollable);
            Assert.assertTrue(country.isDisplayed());
            test.pass("Country is selected");
            country.click();
            screenshotUtil.takeScreenshotAndAttachToAllure();
        }
        catch(Exception e)
        {
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.fail("Country is not selected");
        }
    }
 
    public void updateTheName(String name) {
        try {
            WebElement uName = driver.findElement(updateName);
            uName.sendKeys(name);
            Assert.assertEquals(uName.getText(), name);
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.pass("User Name is updated");
        }
        catch(Exception e)
        {
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.fail("User Name is not updated");
        }
 
    }
    public void clickToButton() {
        try
        {
            WebElement button = driver.findElement(clickTheButton);
            Assert.assertTrue(button.isDisplayed());
            test.pass("Button is Pressed Success");
            button.click();
            screenshotUtil.takeScreenshotAndAttachToAllure();
        }
        catch(Exception e)
        {
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.fail("Button is Pressed Failed");
        }
 
    }
 
}