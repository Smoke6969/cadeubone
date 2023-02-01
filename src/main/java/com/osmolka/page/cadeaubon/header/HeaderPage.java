package com.osmolka.page.cadeaubon.header;

import com.osmolka.fw.annotation.Page;
import com.osmolka.fw.utils.Waiter;
import com.osmolka.page.Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

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

    public SearchResultsComponent searchResults() {
        return searchResultsComponent;
    }

    public void search(String searchValue) {
        edtSearchField.sendKeys(searchValue);
        Waiter.waitABit(3000);
    }

    public void openMainMenu() {
        lnkMainMenu.click();
    }

    @Override
    public boolean isOpened() {
        return wait.until((d) -> this.edtSearchField.isDisplayed());
    }
}
