package utils;
 
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
public class ScreenshotUtil {
 
    private AppiumDriver driver;
 
    public ScreenshotUtil(AppiumDriver driver) {
        this.driver = driver;
    }
 
    public void takeScreenshotAndAttachToAllure() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        AllureManager.saveScreenshot(screenshot);
    }
}