package org.example.selenide.selenideOnly;

import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;


public class SelenideSearchResultsPage {
    private By summaryResults = By.className("gs-title");

    public String getFirstResultSummary(){
        int noVisibleResults = 2;
        return $$(summaryResults)
                .shouldHave(sizeGreaterThan(noVisibleResults))
                .filter(visible)
                .first().getText();
    }
}
