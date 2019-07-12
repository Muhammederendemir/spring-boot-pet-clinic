package com.springbootpetclinic;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Kimlik doğrulama işlemi yapmadan ulaşılabilecek uzantılar
        http.authorizeRequests().antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/image/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();//kimlik doğrulama yapmamaızı ister
        http.formLogin();//login sayfasına yönlendirir
    }
}
