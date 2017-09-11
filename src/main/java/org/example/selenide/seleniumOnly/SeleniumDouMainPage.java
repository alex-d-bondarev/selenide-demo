package org.example.selenide.seleniumOnly;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumDouMainPage {
    @FindBy(name = "q")
    WebElement searchInput;

    public void searchFor(String value){
        searchInput.sendKeys(value);
        searchInput.sendKeys(Keys.RETURN);
    }
}
