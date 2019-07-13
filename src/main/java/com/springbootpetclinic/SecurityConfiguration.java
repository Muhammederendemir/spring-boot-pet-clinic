package com.springbootpetclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Kimlik doğrulama işlemi yapmadan ulaşılabilecek uzantılar
        http.authorizeRequests().antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/image/**", "/login.html/**").permitAll();
        http.authorizeRequests().antMatchers("/rest/**").access("hasRole('EDITOR')");//rest ile başlayan pahtşere sadece EDITOR rolune sahip kisiler erisebilir.
        http.authorizeRequests().antMatchers("/actuator/**").access("hasRole('ADMIN')");
        http.authorizeRequests().anyRequest().authenticated();//kimlik doğrulama yapmamaızı ister
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");//login sayfasına yönlendirir
        http.rememberMe().userDetailsService(userDetailsService);
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
}
