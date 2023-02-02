package com.osmolka.page.cadeaubon.cart;

import com.github.javafaker.Faker;
import com.osmolka.fw.annotation.PageFragment;
import com.osmolka.fw.annotation.Step;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@PageFragment
public class GuestCheckoutDataComponent extends Base {

    @FindBy(css = "input[name='firstName']")
    private WebElement edtName;
    @FindBy(css = "input[name='lastName']")
    private WebElement edtLastName;
    @FindBy(css = "input[name='profileEmail']")
    private WebElement edtEmail;
    @FindBy(css = "input[name='phoneNumber']")
    private WebElement edtPhone;

    @FindBy(xpath = ".//div[contains(text(), 'Ga verder')]")
    private WebElement btnProceedToCheckout;

    @Step
    public void submitData(Faker user) {

        edtName.sendKeys(user.name().firstName());
        edtLastName.sendKeys(user.name().lastName());
        edtEmail.sendKeys(user.internet().emailAddress());
        edtPhone.sendKeys(user.phoneNumber().phoneNumber());

        wait.until((d) -> this.btnProceedToCheckout.isEnabled());
        btnProceedToCheckout.click();
    }

    @Override
    public boolean isOpened() {
        return this.wait.until((d) -> this.edtName.isDisplayed());
    }
}
