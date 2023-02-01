package com.osmolka.fw.config;

import com.github.javafaker.Faker;
import com.osmolka.fw.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker(new Locale("nl_NL"));
    }

}
