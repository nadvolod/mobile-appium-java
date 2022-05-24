package com.mobile;

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

public class IOSSolutionTest {
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
        /*
        * Your code below
        * */

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("language", "en");
        // TODO set the platform name
        capabilities.setCapability("platformName", "iOS");
        //Not specifying platformVersion or the exact device is the most likely to
        //find a device in the cloud
        //TODO run on any iPhone 12
        capabilities.setCapability("deviceName", "iPhone 12.*");
        //TODO set the test name
        capabilities.setCapability("name", name.getMethodName());
        // numerous ways exist for setting app name
        // https://docs.saucelabs.com/dev/test-configuration-options/#app

//        String gitHubAppPath = "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa";
//        capabilities.setCapability("app",gitHubAppPath);
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
        //TODO use accessibility id = "Sauce Labs Backpack"
        WebElement backpack = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        MobileBy.AccessibilityId("Sauce Labs Backpack")));
        backpack.click();
        //TODO use accessibility id = "Add To Cart button"
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Add To Cart button")));
        addToCart.click();
        //TODO get label value of acc is = tab bar option cart
        String itemCount = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        MobileBy.AccessibilityId("tab bar option cart"))).getAttribute("label");
        assertEquals("1", itemCount);

    }
}