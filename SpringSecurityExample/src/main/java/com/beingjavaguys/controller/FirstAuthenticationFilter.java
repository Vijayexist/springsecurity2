package com.beingjavaguys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class FirstAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

	
    public static final String ACEGI_SECURITY_FORM_USERNAME_KEY = "j_tmsessionid";

	protected FirstAuthenticationFilter(String defaultFilterProcessesUrl) 
	{
		super(defaultFilterProcessesUrl);
		System.out.println("FirstAuthenticationFilter constructor");
	}
	
	/**
	 * Checks to see if the current session user has been
	 * authenticated.
	 * 
	 * @return boolean
	 */
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response)
    {
    	boolean requiresAuthentication = super.requiresAuthentication(request, response);
    	System.out.println("FirstAuthenticationFilter requiresAuthentication");
        return requiresAuthentication;
    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
											throws AuthenticationException,	IOException, ServletException
	{
 

		Authentication authRequest = new TestAuthentication( "1234","1234","test" );
		System.out.println("FirstAuthenticationFilter attempt authentication");
		return this.getAuthenticationManager().authenticate(authRequest);
	}
}
