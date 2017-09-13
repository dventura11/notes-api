package com.tenoch.presentation.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
/**
 *Some documentation for this class
 **/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/adm/**", "/bck/**").authenticated()
      .anyRequest().permitAll()
      .and().formLogin().loginPage("/login").permitAll()
      .and().logout().permitAll().logoutSuccessUrl("/");
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationProvider provider) throws Exception {
    auth.authenticationProvider(provider);
  }

}
