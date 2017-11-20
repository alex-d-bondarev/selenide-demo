package org.example.selenide;

import com.codeborne.selenide.Configuration;

public class SelenideDriver {

    public static void run(){
        Configuration.browser = "marionette";
    }
}
