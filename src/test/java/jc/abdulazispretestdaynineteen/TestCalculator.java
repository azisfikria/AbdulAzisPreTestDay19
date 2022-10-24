package jc.abdulazispretestdaynineteen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import jc.abdulazispretestdaynineteen.pages.Calculator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCalculator {
    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_25");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculator = new Calculator(driver);
    }

    @Test(priority = 1)
    public void testAdd() {
        calculator.calcAdd();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "3");
    }

    @Test (priority = 2)
    public void testMultiply() {
        calculator.calcMultiply();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "2");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }
}
