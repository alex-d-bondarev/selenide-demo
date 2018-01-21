package org.example.selenide;

import org.example.selenide.seleniumOnly.SeleniumDouMainPage;
import org.example.selenide.seleniumOnly.SeleniumSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest{

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() throws NullPointerException {
        int waitTimeoutSeconds = 15;

        String driverProperty = "webdriver.gecko.driver";
        String resourcesPath = "drivers/geckodriver_19_1";
        String driverPath = getClass().getClassLoader().getResource(resourcesPath)
                .toString().replace("file:", "");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        System.setProperty(driverProperty, driverPath);

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, waitTimeoutSeconds);
    }

    @Test
    public void seleniumDemo(){
        String douMainPage = "https://dou.ua/";
        String searchText = "Selenide";

        driver.get(douMainPage);
        SeleniumDouMainPage douMain = PageFactory.initElements(driver, SeleniumDouMainPage.class);
        douMain.searchFor(searchText);
        SeleniumSearchResultsPage douSearchResults = PageFactory.initElements(driver, SeleniumSearchResultsPage.class);
        Assert.assertTrue(douSearchResults.getFirstResultSummary(wait)
                        .contains(searchText),
                searchText + " should be shown in first result summary");

        driver.close();
    }
}
