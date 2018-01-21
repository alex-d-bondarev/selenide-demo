package org.example.selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Credit to http://automation-remarks.com/ispolzuiem-nastroiennyi-selenium-grid/index.html
 * and http://www.seleniumeasy.com/selenium-tutorials/how-to-configure-selenium-grid
 * and https://github.com/codeborne/selenide/blob/master/src/test/java/grid/SeleniumGridTest.java
 *
 * Set up steps:
 * 1) open resources/grid in 2 separate terminals and run the following:
 * 2) java -jar selenium-server-standalone-3.8.1.jar -role hub -port 4448
 * 3) java -Dwebdriver.gecko.driver=./../drivers/geckodriver_19_1 -jar selenium-server-standalone-3.8.1.jar -role node -port 5558 -hub http://localhost:4448/grid/register -nodeConfig ./../config/NodeConfig.json
 * 4) Check localhost:4448/grid/console
 */
public class SelenideGridTest {

    @BeforeClass
    public void setUp() throws Exception {
        Configuration.remote = "http://localhost:4448/wd/hub";
        Configuration.browser = "firefox";
    }

    @Test
    public void test(){
        new SelenideDemoTest().runTest();
    }
}
