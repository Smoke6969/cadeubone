package com.osmolka.cadeaubon;

import com.github.javafaker.CreditCardType;
import com.osmolka.SpringBaseTestNGTest;
import com.osmolka.fw.steps.ShopNavigationSteps;
import com.osmolka.page.cadeaubon.cart.ShoppingCartPage;
import com.osmolka.page.cadeaubon.checkout.CheckouBeginPage;
import com.osmolka.page.cadeaubon.header.HeaderPage;
import com.osmolka.page.cadeaubon.payment.VisaPaymentPage;
import com.osmolka.page.cadeaubon.pdp.ProductDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class InitialTests extends SpringBaseTestNGTest {

    @Value("${product.default.id}")
    private String productId;

    @Value("${product.default.name}")
    private String productName;

    @Value("${product.search.default}")
    private String searchString;


    @Autowired
    protected ProductDetailsPage pdp;
    @Autowired
    protected ShopNavigationSteps shopNavigationSteps;
    @Autowired
    protected ShoppingCartPage shoppingCartPage;
    @Autowired
    protected CheckouBeginPage checkouBeginPage;
    @Autowired
    protected VisaPaymentPage visaPaymentPage;
    @Autowired
    protected HeaderPage headerPage;

    @Test
    public void userCanSearchForProducts()  {

        preconditionSteps.startApplication();

        headerPage.search(searchString);

        assertTrue(headerPage.searchResults().isOpened());
        assertTrue(headerPage.searchResults().containsAll(searchString));
    }

    @Test
    public void userCanAddProductToCard() {

        preconditionSteps.startApplication();

        shopNavigationSteps.openPdp(productId);
        assertTrue(pdp.isOpened());

        pdp.details().addProductToCart();
        assertTrue(pdp.userData().isOpened());

        pdp.userData().fill();
        pdp.userData().submit();
        assertTrue(shoppingCartPage.products().isOpened());
        assertTrue(shoppingCartPage.products().isPresent(productName));
    }

    @Test
    public void paymentUnsuccessfulForInvalidCreditCardData() {

        preconditionSteps.startApplication();

        shopNavigationSteps.openPdp(productId);
        assertTrue(pdp.isOpened());

        pdp.details().addProductToCart();
        assertTrue(pdp.userData().isOpened());

        var userData = pdp.userData().fill();
        pdp.userData().submit();
        assertTrue(shoppingCartPage.products().isOpened());

        shoppingCartPage.proceedToCheckout();
        assertTrue(shoppingCartPage.guestCheckoutData().isOpened());

        shoppingCartPage.guestCheckoutData().submitData(userData);
        assertTrue(checkouBeginPage.isOpened());

        checkouBeginPage.openPaymentMethod(CreditCardType.VISA);
        assertTrue(visaPaymentPage.isOpened());

        visaPaymentPage.fillInvalidCardData();
        visaPaymentPage.submitData();

        //Return to Begin page because of an error
        assertTrue(checkouBeginPage.isOpened());
    }

    @Test
    public void userCanOpenMainMenu() {

        preconditionSteps.startApplication();

        headerPage.openMainMenu();

        assertTrue(headerPage.mainMenu().isOpened());
    }
}
