package com.mobile;

import com.mobile.SauceTestWatcher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Android Native App Tests
 */
public class AndroidSolutionTest {
    @Rule
    public TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };
    //This rule allows us to set test status with Junit
    @Rule
    public SauceTestWatcher resultReportingTestWatcher = new SauceTestWatcher();
    public AppiumDriver<MobileElement> driver;
    private MutableCapabilities capabilities;

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    @Before
    public void setup() {
        //Arrange
        capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "Android");
        // pick a galaxy or pixel
        capabilities.setCapability("deviceName", "(Samsung Galaxy S.*)|(Google Pixel.*)");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("idleTimeout", "90");
        // https://appium.io/docs/en/writing-running-appium/caps/
        capabilities.setCapability("newCommandTimeout", "90");
        capabilities.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        capabilities.setCapability("name", name.getMethodName());
    }

    @Test
    public void shouldOpenApp() throws MalformedURLException {
        // numerous ways exist for setting app name
        // https://docs.saucelabs.com/dev/test-configuration-options/#app
        capabilities.setCapability("app",
                "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");

        driver = new AndroidDriver<>(
                new URL("https://" + System.getenv("SAUCE_USERNAME") + ":" +
                        System.getenv("SAUCE_ACCESS_KEY") +
                        "@ondemand.us-west-1.saucelabs.com/wd/hub"),
                capabilities);
        //Setting the driver so that we can report results
        resultReportingTestWatcher.setDriver(driver);

        //Act
        WebDriverWait wait = new WebDriverWait(getDriver(), 10000);
        By backpack = MobileBy.xpath(
                "//android.widget.TextView[contains(@text,'Backpack')]");
        //Assert
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(backpack));
        assertThat(element.isDisplayed()).isTrue();
    }

    @Test
    @Ignore("just a demo of setting dynamic app name")
    public void setAppNameDynamically() throws MalformedURLException {
        /*
         * We can dynamically set an app name from environment variables
         * Just set the value in command line before running `mvn` command
         * */
        capabilities.setCapability("app", System.getenv("ANDROID_APP"));

        driver = new AndroidDriver<>(
                new URL("https://" + System.getenv("SAUCE_USERNAME") + ":" +
                        System.getenv("SAUCE_ACCESS_KEY") +
                        "@ondemand.us-west-1.saucelabs.com/wd/hub"),
                capabilities);
        //Setting the driver so that we can report results
        resultReportingTestWatcher.setDriver(driver);

        //Act
        WebDriverWait wait = new WebDriverWait(getDriver(), 10000);
        By usernameLocator = MobileBy.AccessibilityId("test-Username");
        //Assert
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
    }
}