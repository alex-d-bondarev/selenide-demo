package org.example.selenide;

import org.example.selenide.demo.DemoDouMainPage;
import org.example.selenide.demo.DemoSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest {

    WebDriver driver;

    @Test
    public void demoTest(){
        String douMainPage = "https://dou.ua/";
        String searchText = "Selenide";

        driver = new SeleniumDriver().getDriver();

        driver.get(douMainPage);
        DemoDouMainPage douMain = PageFactory.initElements(driver, DemoDouMainPage.class);
        douMain.searchFor(searchText);
        DemoSearchResultsPage douSearchResults = PageFactory.initElements(driver, DemoSearchResultsPage.class);
        Assert.assertTrue(douSearchResults.getFirstResultSummary().contains(searchText),
                searchText + " should be shown in first result summary");
    }
}
