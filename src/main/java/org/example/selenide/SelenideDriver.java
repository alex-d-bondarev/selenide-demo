package org.example.selenide;

import com.codeborne.selenide.Configuration;

public class SelenideDriver {

    static final String driverProperty = "webdriver.gecko.driver";
    static final String path = "/Users/Alex/GitHub/selenide-demo/selenide-demo/drivers/geckodriver";
    static final String browser = "marionette";

    public static void setDriver(){
        Configuration.browser = browser;
        System.setProperty(driverProperty, path);
    }
}
