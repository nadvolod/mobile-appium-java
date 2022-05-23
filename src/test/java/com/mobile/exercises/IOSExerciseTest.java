package com.mobile.exercises;

import com.mobile.SauceTestWatcher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IOSExerciseTest {
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
    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("language", "en");
        // TODO set the platform name
        // TODO run on any iPhone 12
        // TODO set the test name

        // numerous ways exist for setting app name
        // https://docs.saucelabs.com/dev/test-configuration-options/#app

        // TODO read the app name from your sauce file storage
        String appPathReactNativeVersion = "iOS-Real-Device-MyRNDemoApp.1.3.0-162.ipa";
        capabilities.setCapability("app", "storage:filename=" + appPathReactNativeVersion);

        driver = new IOSDriver(
                new URL("https://" + System.getenv("SAUCE_USERNAME") + ":" +
                        System.getenv("SAUCE_ACCESS_KEY") +
                        "@ondemand.us-west-1.saucelabs.com/wd/hub"),
                capabilities);
        //Setting the driver so that we can report results
        resultReportingTestWatcher.setDriver(driver);
    }

    @Test
    public void shouldOpenApp() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10000);
        //TODO use accessibility id = "Sauce Labs Backpack" and click it
        //TODO use accessibility id = "Add To Cart button" and click it
        //TODO get "label" value of accessibility id = "tab bar option cart"
        String itemCount = "0";
        // don't modify the assertion
        assertEquals("1", itemCount);

    }
}