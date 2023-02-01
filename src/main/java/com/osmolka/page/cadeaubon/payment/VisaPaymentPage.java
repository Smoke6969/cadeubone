package com.osmolka.page.cadeaubon.payment;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.osmolka.fw.annotation.Page;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class VisaPaymentPage extends Base {

    @Autowired Faker userData;

    @FindBy(css = "[name='brq_SERVICE_visa_CustomerCardName']")
    private WebElement edtCardName;

    @FindBy(css = "[name='brmv_brq_SERVICE_visa_VisaCreditcardNumber']")
    private WebElement edtCardNumber;

    @FindBy(css = "[name='brmv_brq_CardExpirationDate_month']")
    private Select cbxExpMoth;

    @FindBy(css = "[name='brmv_brq_CardExpirationDate_year']")
    private Select cbxExpYear;

    @FindBy(css = "[name='brq_SERVICE_visa_CVV3']")
    private WebElement edtCvv;

    @FindBy(css = "[id='button_continue']")
    private WebElement btnSubmit;

    public void fillInvalidCardData() {
        edtCardName.sendKeys(userData.name().firstName() + " " + userData.name().lastName());
        edtCardNumber.sendKeys(userData.finance().creditCard(CreditCardType.VISA));
        edtCvv.sendKeys("111");
    }

    public void submitData() {
        wait.until((d) -> this.btnSubmit.isEnabled());
        btnSubmit.click();
    }


    @Override
    public boolean isOpened() {
        return this.wait.until((d) -> this.edtCardName.isDisplayed());
    }
}
