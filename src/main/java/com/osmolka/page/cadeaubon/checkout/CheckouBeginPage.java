package com.osmolka.page.cadeaubon.checkout;

import com.github.javafaker.CreditCardType;
import com.osmolka.fw.annotation.Page;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class CheckouBeginPage extends Base {

    @FindBy(xpath = ".//p[contains(text(), 'Visa')]")
    private WebElement frgVisaPayment;

    @FindBy(xpath = ".//div[contains(text(), 'Betaling afronden')]")
    private WebElement btnProceedToCheckout;

    public void openPaymentMethod(CreditCardType card) {
        switch (card) {
            case VISA:
                frgVisaPayment.click();
                wait.until((d) -> this.btnProceedToCheckout.isEnabled());
                btnProceedToCheckout.click();
        }
    }

    @Override
    public boolean isOpened() {
        return this.wait.until((d) -> this.frgVisaPayment.isDisplayed());
    }
}
