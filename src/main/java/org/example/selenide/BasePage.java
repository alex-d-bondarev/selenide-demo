package org.example.selenide;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(){
        setUpPage();
    }

    private static void setUpPage(){

        driver = SeleniumDriver.getDriver();
        wait = SeleniumDriver.getWait();

    }
}
