package org.example.selenide.selenideOnly;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;


public class SelenideSearchResultsPage {
    private By summaryResults = By.className("gs-title");

    public String getFirstResultSummary(){
        int noResults = 0;
        return $$(summaryResults).shouldHave(sizeGreaterThan(noResults)).filter(Condition.visible).first().getText();
    }
}
