package org.example.selenide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
    private static int waitTimeoutSeconds = 15;

    private static SeleniumDriver instance = null;
    private static WebDriver driver = null;
    private static WebDriverWait wait = null;

    private SeleniumDriver(){
        driver = getFireFoxDriver();
        wait = getWaitInstance();
    }

    public static WebDriver getDriver(){
        if (instance == null) {
            instance = new SeleniumDriver();
        }
        return driver;
    }

    public static WebDriverWait getWait(){
        if (instance == null) {
            instance = new SeleniumDriver();
        }
        return wait;
    }

    private WebDriver getFireFoxDriver(){
        String driverProperty = "webdriver.gecko.driver";
        String path = "/Users/Alex/GitHub/selenide-demo/selenide-demo/drivers/geckodriver";

        System.setProperty(driverProperty, path);
        return new FirefoxDriver();
    }

    private WebDriverWait getWaitInstance(){
        return new WebDriverWait(driver, waitTimeoutSeconds);
    }
}
