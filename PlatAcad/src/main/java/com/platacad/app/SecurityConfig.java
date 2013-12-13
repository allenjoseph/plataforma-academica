package com.platacad.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
@Import({ DataBaseConfig.class })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private DataSource dataSource;
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/resources/**","/login.html");
    }

	@Autowired
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(getUserQuery())
                .authoritiesByUsernameQuery(getAuthoritiesQuery())
                .rolePrefix("");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().hasAnyAuthority("ALUMNO","DOCENTE","ADMIN")
				.and()
			.formLogin()
				.loginPage("/login.html")
				.defaultSuccessUrl("/success-login.html", true)
	            .loginProcessingUrl("/process-login.html")
				.failureUrl("/error-login.html")
				.usernameParameter("security_username")
	            .passwordParameter("security_password")
	            .permitAll() 
	            .and()
	        .logout()
	            .logoutSuccessUrl("/login.html")
	            .logoutUrl("/logout.html")
	            .permitAll()
	            .and()
	        .rememberMe()
	            .and()
	        .csrf()
	            .disable();
	}
	
	private String getUserQuery() {
        return "SELECT id_usuario_pk as username, password as password, 1 as enabled "
                + "FROM usuario "
                + "WHERE id_usuario_pk = ?";
    }

    private String getAuthoritiesQuery() {
        return "SELECT DISTINCT u.id_usuario_pk as username, p.parametro as authority "
                + "FROM usuario u, parametros p "
                + "WHERE u.rol_param = p.id_parametro_pk "
                + "AND u.id_usuario_pk = ? "
                + "AND u.estado_param = 1";
    }
}
