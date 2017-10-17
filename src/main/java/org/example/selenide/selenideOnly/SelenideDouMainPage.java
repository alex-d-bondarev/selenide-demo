package org.example.selenide.selenideOnly;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideDouMainPage {
    private By searchInput = By.name("q");


    public void searchFor(String value){
        $(searchInput).setValue(value).pressEnter();
    }
}
