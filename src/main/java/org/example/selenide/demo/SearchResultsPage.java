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
        wait.until(myPrettyWaitNonEmptyList(summaryResults));
        for (WebElement result : summaryResults) {
            if (!result.getText().equals(""))
                return result.getText();
        }
        return null;
    }

    ///////////////////////////
    // Wait for many results //
    ///////////////////////////
    
    private void myUglyWaitNonEmptyList(){
        for(int i = 10; i > 0 && summaryResults.size() == 0; i--){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // Do nothing
            }
        }
    }

    private static ExpectedCondition<List<WebElement>> myPrettyWaitNonEmptyList(
            final List<WebElement> elements){
        return new ExpectedCondition<List<WebElement>>() {

            public List<WebElement> apply(WebDriver driver) {
                int minimumSearchResults = 3;
                return elements.size() >= minimumSearchResults ? elements : null;
            }

            @Override
            public String toString() {
                return "non empty list of " + elements;
            }
        };
    }
}
