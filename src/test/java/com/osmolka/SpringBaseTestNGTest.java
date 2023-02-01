package com.osmolka;

import com.osmolka.fw.steps.PreconditionSteps;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@SpringBootTest
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;
    @Autowired
    public PreconditionSteps preconditionSteps;

    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

}
