package org.example.selenide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
    private static final int waitTimeoutSeconds = 15;
    private static SeleniumDriver instance = null;
    private WebDriver driver = null;
    private WebDriverWait wait = null;


    private SeleniumDriver(){
        new FirefoxSetUp().run();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, waitTimeoutSeconds);
    }


    public static SeleniumDriver getInstance(){
        if (instance == null) {
            instance = new SeleniumDriver();
        }
        return instance;
    }


    public WebDriver getDriver(){
        return driver;
    }


    public WebDriverWait getWait(){
        return wait;
    }
}
