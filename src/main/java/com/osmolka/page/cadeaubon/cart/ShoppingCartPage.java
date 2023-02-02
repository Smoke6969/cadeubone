package com.osmolka.page.cadeaubon.cart;

import com.osmolka.fw.annotation.Page;
import com.osmolka.fw.annotation.Step;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class ShoppingCartPage extends Base {

    @Autowired
    protected CartProductsComponent cartProductsComponent;
    @Autowired
    protected GuestCheckoutDataComponent guestCheckoutDataComponent;

    @FindBy(xpath = ".//div[contains(text(), 'Veilig afrekenen')]")
    private WebElement btnProceedToCheckout;


    public CartProductsComponent products() {
        return cartProductsComponent;
    }

    public GuestCheckoutDataComponent guestCheckoutData() {
        return guestCheckoutDataComponent;
    }

    @Step
    public void proceedToCheckout() {
        btnProceedToCheckout.click();
    }

    @Override
    public boolean isOpened() {
        return cartProductsComponent.isOpened();
    }
}
