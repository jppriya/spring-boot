package com.jp.poc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//enables security in the method level
@EnableGlobalMethodSecurity(prePostEnabled = true)
//enables security for the application
@EnableWebSecurity

//WebSecurityConfigurerAdapter is for writing the web security config
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	Cross-Site Request Forgery (CSRF) 
	
	//hasAuthority - with ROLE_
	//hasRoles - without ROLE_
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/user").hasAuthority("ROLE_ADMIN").anyRequest()
				.fullyAuthenticated().and().formLogin().and().httpBasic();

	}
	

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
        .withUser("abc@gmail.com").password(passwordEncoder().encode("Welcome123")).roles("USER").and()
        .withUser("def@gmail.com").password(passwordEncoder().encode("Welcome123")).roles("ADMIN");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

}
