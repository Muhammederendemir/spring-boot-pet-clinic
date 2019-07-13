package com.springbootpetclinic;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(value = 0)//
public class H2SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/h2-console/**").authorizeRequests().anyRequest().permitAll();//  /h2-console ile başlayan bütün istekleri yakalayacak bir metot
        //permitAll() herkesin erişebilmesi için
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
