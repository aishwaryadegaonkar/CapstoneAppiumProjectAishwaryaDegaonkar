package utils;
 
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
 
import java.io.File;
//import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
//import java.net.URL;
import java.nio.file.Paths;
//import java.util.concurrent.TimeUnit;
public class DriverManager {
    private static AppiumDriver driver;
    public static AppiumDriverLocalService service;
 
    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
 
                    service.start();
                    //appium server start
 
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setDeviceName("emulator-5554");
                    options.setApp(Paths.get("app/General-Store.apk").toAbsolutePath().toString());
 
                    
 
                    try {
                        driver = new AndroidDriver((new URI("http://127.0.0.1:4723/")).toURL(), options);
                    } catch (MalformedURLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        quitDriver();
                    } catch (URISyntaxException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        quitDriver();
                    }
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("deviceName", "emulator-5554");
//            capabilities.setCapability("platformVersion", "14");
//            capabilities.setCapability("automationName", "UiAutomator2");
//            capabilities.setCapability("app", Paths.get("app/General-Store.apk").toAbsolutePath().toString()); // Path to your APK file
//            capabilities.setCapability("appPackage", "com.androidsample.generalstore");
//            capabilities.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");
//            
//            capabilities.setCapability("platformName", "Android");
//          capabilities.setCapability("platformVersion", "14");
//          capabilities.setCapability("udid", "emulator-5554");
//          capabilities.setCapability("appPackage", "com.google.android.calculator");
//          capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
//          capabilities.setCapability("automationName", "uiautomator2");
            
 
//            try {
//                driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
        }
        return driver;
    }
 
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        service.stop();
    }
}