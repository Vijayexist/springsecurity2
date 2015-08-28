package com.beingjavaguys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class SecondAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

	protected SecondAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		// TODO Auto-generated constructor stub
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
	    	System.out.println("SecondAuthenticationFilter requiresAuthenticatin metod");
	        return requiresAuthentication;
	    }

		@Override
		public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
												throws AuthenticationException,	IOException, ServletException
		{
	 

			Authentication authRequest = new TestAuthentication( "3035","ss3035","test" );
			return this.getAuthenticationManager().authenticate(authRequest);
		}

}
