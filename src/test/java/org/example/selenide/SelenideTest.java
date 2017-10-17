package org.example.selenide;

import org.example.selenide.selenideOnly.SelenideDouMainPage;
import org.example.selenide.selenideOnly.SelenideSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void selenideDemo(){
        final String douMainPage = "https://dou.ua/";
        final String searchText = "Selenide";

        SelenideDouMainPage douMain = new SelenideDouMainPage();
        SelenideSearchResultsPage douSearchResults = new SelenideSearchResultsPage();

        SelenideDriver.setDriver();

        open(douMainPage);
        douMain.searchFor(searchText);
        Assert.assertTrue(douSearchResults.getFirstResultSummary().contains(searchText),
                searchText + " should be shown in first result summary");
    }
}
