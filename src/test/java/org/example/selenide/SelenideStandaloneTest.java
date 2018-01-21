package org.example.selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelenideStandaloneTest {

    @BeforeTest
    public void setUp(){
        Configuration.browser = "firefox";
    }

    @Test
    public void test(){
        new SelenideDemoTest().runTest();
    }
}
