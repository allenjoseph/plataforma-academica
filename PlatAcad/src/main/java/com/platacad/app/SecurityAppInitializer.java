package com.platacad.app;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class SecurityAppInitializer extends AbstractSecurityWebApplicationInitializer {
	 /**
     * Instruct Spring Security to use the {@link DispatcherServlet}'s
     * {@link WebApplicationContext} to find the springSecurityFilterChain.
     */
    @Override
    protected String getDispatcherWebApplicationContextSuffix() {
        return AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME;
    }

    /**
     * Insert the following filters before Spring Security. Be careful when inserting
     * filters before Spring Security!
     */
    @Override
    protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
    }

    /**
     * Register the {@link HttpSessionEventPublisher}
     */
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }

}
