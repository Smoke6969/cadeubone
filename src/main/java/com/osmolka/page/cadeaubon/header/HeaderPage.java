package com.osmolka.page.cadeaubon.header;

import com.osmolka.fw.annotation.Page;
import com.osmolka.fw.annotation.Step;
import com.osmolka.fw.utils.Waiter;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class HeaderPage extends Base {

    @Autowired
    private SearchResultsComponent searchResultsComponent;
    @Autowired
    private MainMenuComponent mainMenuComponent;

    @FindBy(css = "[placeholder='Waar ben je naar op zoek?']")
    private WebElement edtSearchField;

    @FindBy(css = "._3fa035e23f35c9ad909cca895ad80b5a-css")
    private WebElement lnkMainMenu;

    public MainMenuComponent mainMenu() {
        return mainMenuComponent;
    }

    @Step
    public SearchResultsComponent searchResults() {
        return searchResultsComponent;
    }

    @Step
    public void search(String searchValue) {
        edtSearchField.sendKeys(searchValue);
        Waiter.waitABit(3000);
    }

    @Step
    public void openMainMenu() {
        lnkMainMenu.click();
    }

    @Override
    public boolean isOpened() {
        return wait.until((d) -> this.edtSearchField.isDisplayed());
    }
}
