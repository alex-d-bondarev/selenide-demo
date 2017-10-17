package org.example.selenide;

import com.codeborne.selenide.Configuration;

public class SelenideDriver {
    private static final String BROWSER = "marionette";


    public static void setDriver(){
        Configuration.browser = BROWSER;
        new FirefoxSetUp().run();
    }
}
