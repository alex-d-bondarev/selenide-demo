package org.example.selenide;


import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxSetUp {

    public void run(){
        String driverProperty = "webdriver.gecko.driver";
        String resourcesPath = "drivers/geckodriver_19_1";
        String driverPath = getClass().getClassLoader().getResource(resourcesPath)
                .toString().replace("file:", "");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        System.setProperty(driverProperty, driverPath);
    }
}
