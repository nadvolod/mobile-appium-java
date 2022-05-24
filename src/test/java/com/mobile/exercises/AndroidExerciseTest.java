package com.mobile.exercises;

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

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Android Native App Tests
 */
public class AndroidExerciseTest {
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
        /*
        * Write your code below
        * */

        // TODO "platformName", "Android"
        // TODO "deviceName", "(Samsung Galaxy S.*)|(Google Pixel.*)"
        //TODO "automationName", "UIAutomator2"
        //TODO "idleTimeout", "90"
        //TODO "newCommandTimeout", "90"
        //TODO "appWaitActivity", "com.saucelabs.mydemoapp.rn.MainActivity"
        //TODO "name", name.getMethodName()
    }

    @Test
    public void shouldOpenApp() throws MalformedURLException {
        // numerous ways exist for setting app name
        // https://docs.saucelabs.com/dev/test-configuration-options/#app
        // TODO upload your app to sauce storage and pass it in here
        capabilities.setCapability("app",
                "storage:filename=");

        //TODO create a new AndroidDriver<>()

        //Setting the driver so that we can report results
        resultReportingTestWatcher.setDriver(driver);

        //TODO create a new explicit wait

        // use this element for your search
        By backpack = MobileBy.xpath(
                "//android.widget.TextView[contains(@text,'Backpack')]");
        //TODO wait until the backpack is visible
        WebElement element = null;
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