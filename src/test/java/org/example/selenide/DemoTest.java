package org.example.selenide;

import org.example.selenide.demo.DouMainPage;
import org.example.selenide.demo.SearchResultsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest extends BaseTest {

    @Test
    public void presentationDemo(){
        String douMainPage = "https://dou.ua/";
        String searchText = "Selenide";

        driver.get(douMainPage);
        DouMainPage douMain = PageFactory.initElements(driver, DouMainPage.class);
        douMain.searchFor(searchText);
        SearchResultsPage douSearchResults = PageFactory.initElements(driver, SearchResultsPage.class);
        Assert.assertTrue(douSearchResults.getFirstResultSummary().contains(searchText),
                searchText + " should be shown in first result summary");
    }
}
