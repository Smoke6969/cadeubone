package com.osmolka.fw.steps;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CookieSteps {

    @Autowired
    protected WebDriver driver;

    @Value("${cookies.default}")
    private String cookies;

    public void setCookies(){

            if(cookies.length() > 0){
                var cookiePair = cookies.split(":");
                driver.manage().addCookie(new Cookie(cookiePair[0], cookiePair[1]));
            }

            driver.navigate().refresh();
    }
}

