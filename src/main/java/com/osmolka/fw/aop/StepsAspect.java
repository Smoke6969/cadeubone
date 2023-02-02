package com.osmolka.fw.aop;

import com.osmolka.fw.annotation.Step;
import com.osmolka.page.Base;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StepsAspect {

    @Before("execution(public * *(..)) && target(page) && @annotation(step)")
    public void before(Base page, Step step) {
        page.isOpened();
    }
}
