package com.osmolka.page.cadeaubon.cart;

import com.osmolka.fw.annotation.PageFragment;
import com.osmolka.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.StreamTokenizer;
import java.util.List;


@PageFragment
public class CartProductsComponent extends Base {

    //TODO: (change selector) add readable class for product name
    @FindBy(css = ".b5ef9cb4a3d15d4256aa23e3ad81e20d-css")
    private List<WebElement> productNames;

    public boolean isPresent(String productName) {
        return productNames.stream().filter(product -> product.getText().contains(productName)).findFirst().isPresent();
    }

    @Override
    public boolean isOpened() {
        return this.wait.until((d) -> this.productNames.size() > 0);
    }
}
