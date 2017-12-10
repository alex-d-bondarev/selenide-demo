package org.example.selenide;

import org.example.selenide.seleniumOnly.SeleniumDouMainPage;
import org.example.selenide.seleniumOnly.SeleniumSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest{

    @Test
    public void seleniumDemo(){
        String douMainPage = "https://dou.ua/";
        String searchText = "Selenide";
        WebDriver driver = SeleniumDriver.getInstance().getDriver();

        driver.get(douMainPage);
        SeleniumDouMainPage douMain = PageFactory.initElements(driver, SeleniumDouMainPage.class);
        douMain.searchFor(searchText);
        SeleniumSearchResultsPage douSearchResults = PageFactory.initElements(driver, SeleniumSearchResultsPage.class);
        Assert.assertTrue(douSearchResults.getFirstResultSummary()
                        .contains(searchText),
                searchText + " should be shown in first result summary");

        driver.close();
    }
}
