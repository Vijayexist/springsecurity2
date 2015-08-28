package com.beingjavaguys.controller;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class TestAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		TestAuthentication cybAuth = null;
		System.out.println("TestAuthenticationProvider authenticate method" );
		if( authentication instanceof TestAuthentication ) {
			cybAuth = (TestAuthentication) authentication;
        	
        	
        	
			GrantedAuthority[] grantedAuthorities = new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_ADMIN")};
			cybAuth = new TestAuthentication( cybAuth.getPrincipal().toString(), 
												cybAuth.getCredentials().toString(),
												cybAuth.getDetails(), 
												grantedAuthorities );
		}
		return cybAuth;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
