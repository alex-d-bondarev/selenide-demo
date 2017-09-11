package org.example.selenide;

import org.openqa.selenium.WebDriver;

/**
 * Created by Alex on 9/11/17.
 */
public abstract class BaseTest {

    public static WebDriver driver;

    public BaseTest(){
        setUpDriver();
    }

    private static void setUpDriver(){
        driver = SeleniumDriver.getDriver();
    }
}
