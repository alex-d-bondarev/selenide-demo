package org.example.selenide;

import org.example.selenide.selenideOnly.SelenideDouMainPage;
import org.example.selenide.selenideOnly.SelenideSearchResultsPage;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDemoTest {
    public void runTest(){
        final String douMainPage = "https://dou.ua/";
        final String searchText = "Selenide";

        SelenideDouMainPage douMain = new SelenideDouMainPage();
        SelenideSearchResultsPage douSearchResults = new SelenideSearchResultsPage();

        open(douMainPage);
        douMain.searchFor(searchText);
        Assert.assertTrue(douSearchResults.getFirstResultSummary()
                        .contains(searchText),
                searchText + " should be shown in first result summary");
        close();
    }
}
