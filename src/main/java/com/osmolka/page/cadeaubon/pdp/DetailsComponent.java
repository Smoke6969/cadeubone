package com.osmolka.page.cadeaubon.pdp;

import com.osmolka.fw.annotation.PageFragment;
import com.osmolka.fw.utils.Waiter;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class DetailsComponent extends Base {

    @FindBy(css = "[type='button']")
    private WebElement btnAddToCart;

    public void addProductToCart() {
        btnAddToCart.click();
        Waiter.waitABit(3000);
    }

    @Override
    public boolean isOpened() {
        return this.wait.until((d) -> this.btnAddToCart.isDisplayed());
    }
}
