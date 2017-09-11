package org.example.selenide.demo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoDouMainPage {
    @FindBy(name = "q")
    WebElement searchInput;

    public void searchFor(String value){
        searchInput.sendKeys(value);
        searchInput.sendKeys(Keys.RETURN);
    }
}
