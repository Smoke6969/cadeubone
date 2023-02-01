package com.osmolka.fw.steps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(
        {
                "cookies/cookies.properties",
                "product/product.properties"
        })
public class PreconditionSteps {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected CookieSteps cookieSteps;

    @Value("${application.url}")
    private String url;

    public void startApplication(){
        driver.get(url);
        driver.manage().window().maximize();
        cookieSteps.setCookies();
    }
}
