package com.osmolka.page.cadeaubon.header;

import com.osmolka.fw.annotation.PageFragment;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.util.StringUtils;

import java.util.List;

@PageFragment
public class SearchResultsComponent extends Base {

    @FindBy(css = "._42f713dad2488b7e2407a870b6bde31a-css a")
    private List<WebElement> lstResultLinks;

    public boolean containsAll(String searchString) {

        for(WebElement currentResult : lstResultLinks) {
            if(!currentResult.getAttribute("href").contains(searchString)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isOpened() {
        return wait.until((d) -> this.lstResultLinks.size() > 0);
    }
}
