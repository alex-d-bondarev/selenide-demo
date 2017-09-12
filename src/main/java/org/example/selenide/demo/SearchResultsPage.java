package org.example.selenide.demo;

import org.example.selenide.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;


public class SearchResultsPage extends BasePage{
    @FindBy(xpath = ".//div[@class='gsc-result-info']")
    WebElement resultsInfo;

    @FindBy(className = "gs-title")
    List<WebElement> summaryResults;

    public String getFirstResultSummary(){
        int minimumAmountOfSearchResults = 3;
        wait.until(prettyListSizeGreaterThan(summaryResults, minimumAmountOfSearchResults));
        for (WebElement result : summaryResults) {
            if (result.isDisplayed())
                return result.getText();
        }
        return null;
    }

    ///////////////////////////
    // Wait for many results //
    ///////////////////////////
    
    private void uglyListSizeGreaterThan(int size){
        for(int i = 10; i > 0 && summaryResults.size() >- size; i--){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // Do nothing
            }
        }
    }

    private static ExpectedCondition<List<WebElement>> prettyListSizeGreaterThan(
            final List<WebElement> elements, final int size){
        return new ExpectedCondition<List<WebElement>>() {

            public List<WebElement> apply(WebDriver driver) {
                return elements.size() >= size ? elements : null;
            }

            @Override
            public String toString() {
                return "non empty list of " + elements;
            }
        };
    }
}
