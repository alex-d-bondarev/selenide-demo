package org.example.selenide;

import org.example.selenide.seleniumOnly.SeleniumDouMainPage;
import org.example.selenide.seleniumOnly.SeleniumSearchResultsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTest extends BaseTest {

    @Test
    public void seleniumDemo(){
        String douMainPage = "https://dou.ua/";
        String searchText = "Selenide";

        driver.get(douMainPage);
        SeleniumDouMainPage douMain = PageFactory.initElements(driver, SeleniumDouMainPage.class);
        douMain.searchFor(searchText);
        SeleniumSearchResultsPage douSearchResults = PageFactory.initElements(driver, SeleniumSearchResultsPage.class);
        Assert.assertTrue(douSearchResults.getFirstResultSummary().contains(searchText),
                searchText + " should be shown in first result summary");
    }
}
