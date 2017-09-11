package org.example.selenide;

import org.example.selenide.selenideOnly.SelenideDouMainPage;
import org.example.selenide.selenideOnly.SelenideSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SelenideTest {

    WebDriver driver;

    SelenideDouMainPage douMain = new SelenideDouMainPage();
    SelenideSearchResultsPage douSearchResults = new SelenideSearchResultsPage();

    @Test
    public void selenideDemo(){
        String douMainPage = "https://dou.ua/";
        String searchText = "Selenide";

        driver = new SelenideDriver().getDriver();

        driver.get(douMainPage);
        douMain.searchFor(searchText);
        Assert.assertTrue(douSearchResults.getFirstResultSummary().contains(searchText),
                searchText + " should be shown in first result summary");

    }
}
