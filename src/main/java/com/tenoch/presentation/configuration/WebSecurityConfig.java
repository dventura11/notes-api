package com.tenoch.presentation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/adm/*", "/bck/*").authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/view/login")
                .permitAll()
                .and()
            .logout()
                .permitAll().logoutSuccessUrl("/");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password("admin123").roles("ADMIN");
    }    
    
    @Autowired
    @Bean
    public SpringTemplateEngine getEngine(ITemplateResolver templateResolver){
    	SpringTemplateEngine engine = new SpringTemplateEngine();
    	engine.setTemplateResolver(templateResolver);
    	engine.addDialect(new SpringSecurityDialect());
		return engine;
    }
}
