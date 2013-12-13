package com.platacad.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
@Import({ DataBaseConfig.class })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth
         .jdbcAuthentication()
             .dataSource(dataSource)
             .withDefaultSchema()
             .withUser("user").password("password").roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login.html").permitAll();
	}
}
