package com.okursan.author.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}password").roles("KULLANICI", "EDITOR")
                .and()
                .withUser("user").password("{noop}password").roles("KULLANICI");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/author/**").hasRole("KULLANICI")
                .antMatchers("/author/**").hasRole("EDITOR")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
