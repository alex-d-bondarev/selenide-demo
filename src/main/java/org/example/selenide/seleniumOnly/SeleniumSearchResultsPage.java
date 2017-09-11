package org.example.selenide.seleniumOnly;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class SeleniumSearchResultsPage {
    @FindBy(xpath = ".//div[@class='gsc-result-info']")
    WebElement resultsInfo;

    @FindBy(className = "gs-title")
    List<WebElement> summaryResults;

    public String getFirstResultSummary(){
        ExpectedConditions.visibilityOf(resultsInfo);
        ExpectedConditions.visibilityOfAllElements(summaryResults); // This one does not help
        myUglyWait();
        for (WebElement result : summaryResults) {
            if (!result.getText().equals(""))
                return result.getText();
        }
        return null;
    }

    private void myUglyWait(){
        for(int i = 10; i > 0 && summaryResults.size() == 0; i--){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // Do nothing
            }
        }
    }
}
