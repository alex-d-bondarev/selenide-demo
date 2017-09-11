package org.example.selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelenideDriver {
    public WebDriver getDriver(){
        String driverProperty = "webdriver.gecko.driver";
        String path = "/Users/Alex/GitHub/selenide-demo/selenide-demo/drivers/geckodriver";

        System.setProperty(driverProperty, path);
        WebDriver driver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(driver);

        return driver;
    }
}
