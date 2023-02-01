package com.osmolka.page.cadeaubon.header;

import com.osmolka.fw.annotation.PageFragment;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class MainMenuComponent extends Base {

    @FindBy(css = ".d5f0817d4922284f4183423cbd914755-css")
    private List<WebElement> lstMenuLinks;

    @Override
    public boolean isOpened() {
        return wait.until((d) -> this.lstMenuLinks.size() > 0 && lstMenuLinks.get(0).isDisplayed());
    }
}
