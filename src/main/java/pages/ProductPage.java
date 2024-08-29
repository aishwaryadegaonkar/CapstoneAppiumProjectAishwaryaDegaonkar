package pages;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
import io.appium.java_client.AppiumDriver;
import utils.ExtentManager;
import utils.ScreenshotUtil;
 
public class ProductPage {
    By productPageTitle = By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]");
    protected AppiumDriver driver;
    WebDriverWait wait;
    ExtentReports extent;
    ExtentTest test;
    private ScreenshotUtil screenshotUtil;
    public ProductPage(AppiumDriver driver) {
        this.driver=driver;
        extent = ExtentManager.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        test = ExtentManager.createTest("Display Product","User able see the Product Page");
        screenshotUtil = new ScreenshotUtil(driver);
    }
 
    public void isProductScreenVisible() {
        try {
            WebElement productScreen =wait.until(ExpectedConditions.visibilityOfElementLocated(productPageTitle));
            Assert.assertTrue(productScreen.isDisplayed());
            test.pass("Product Title is visible");
            screenshotUtil.takeScreenshotAndAttachToAllure();
        }catch(Exception e) {
            screenshotUtil.takeScreenshotAndAttachToAllure();
            test.fail("Product Title is invisible");
        }
    }
 
}