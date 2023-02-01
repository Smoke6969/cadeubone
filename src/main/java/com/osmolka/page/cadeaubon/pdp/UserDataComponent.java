package com.osmolka.page.cadeaubon.pdp;

import com.github.javafaker.Faker;
import com.osmolka.fw.annotation.PageFragment;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageFragment
public class UserDataComponent extends Base {

    @Autowired
    private Faker user;

    @FindBy(css = "input[name='name']")
    private WebElement edtName;
    @FindBy(css = "input[name='postCode']")
    private WebElement edtPostCode;
    @FindBy(css = "input[name='houseNumber']")
    private WebElement edtHouseNumber;
    @FindBy(css = "input[name='additional']")
    private WebElement edtAdditionalInfo;
    @FindBy(css = "input[name='street']")
    private WebElement edtStreet;
    @FindBy(css = "input[name='city']")
    private WebElement edtCity;
    //TODO: change selector for more precise
    @FindBy(css = "[type='button']")
    private List<WebElement> btnAddToCart;


    public Faker fill() {

        edtName.sendKeys(user.name().firstName());
        edtPostCode.sendKeys(user.address().zipCode());
        edtHouseNumber.sendKeys(user.address().streetAddressNumber());
        edtAdditionalInfo.click();
        wait.until((d) -> this.edtStreet.isDisplayed());

        edtStreet.sendKeys(user.address().streetName());
        edtCity.sendKeys(user.address().city());

        return user;
    }

    public void submit() {

        wait.until((d) -> this.btnAddToCart.get(1).isDisplayed() && this.btnAddToCart.get(1).isEnabled());
        btnAddToCart.get(1).click();
    }

    @Override
    public boolean isOpened() {
        return this.wait.until((d) -> this.edtName.isDisplayed());
    }
}
