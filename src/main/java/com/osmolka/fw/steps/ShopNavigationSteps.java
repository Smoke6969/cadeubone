package com.osmolka.fw.steps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.stereotype.Component;

@Component
@PropertySource("navigation/urls.properties")
public class ShopNavigationSteps {

    @Value("${application.url}")
    protected String appUrl;

    @Value("${products.all}")
    protected String allProductsPath;

    @Autowired
   protected WebDriver driver;

    public void openPdp(String productId) {
        driver.navigate().to(appUrl + allProductsPath + productId);
    }
}
