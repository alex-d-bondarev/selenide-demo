package org.example.selenide.seleniumOnly;

import org.example.selenide.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;


public class SeleniumSearchResultsPage{
    @FindBy(className = "gs-title")
    private List<WebElement> summaryResults;


    public String getFirstResultSummary(){
        int minimumAmountOfSearchResults = 3;
        WebDriverWait wait = SeleniumDriver.getInstance().getWait();

        wait.until(prettyListSizeGreaterThan(summaryResults, minimumAmountOfSearchResults));
        for (WebElement result : summaryResults) {
            if (result.isDisplayed())
                return result.getText();
        }
        return null;
    }


    ////////////////////
    // Custom waiters //
    ////////////////////

    private void uglyListSizeGreaterThan(int size){
        for(int i = 10; i > 0 && summaryResults.size() >- size; i--){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // Do nothing for now
            }
        }
    }


    private static Function<WebDriver, Boolean> prettyListSizeGreaterThan(
            final List<WebElement> elements, final int size){
        return new Function<WebDriver, Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                elements.forEach(el -> {
                    if(!el.isDisplayed()) elements.remove(el);
                });
                return elements.size() >= size;
            }

            @Override
            public String toString() {
                return "non empty list of " + elements;
            }
        };
    }
}
