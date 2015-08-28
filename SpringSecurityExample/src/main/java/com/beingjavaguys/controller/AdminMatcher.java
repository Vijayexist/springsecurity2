package com.beingjavaguys.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.RequestMatcher;

public class AdminMatcher implements RequestMatcher {
	private static final String ADMIN_LOGIN_REGEX = ".*/admin.jsp|.*/admin|.*/login.jsf";

	private static Pattern pattern = Pattern.compile(ADMIN_LOGIN_REGEX);
	
	@Override
	public boolean matches(HttpServletRequest request)
	{
		try{
			String url = request.getRequestURL().toString();
			System.out.println("Admin matcher");
			return matches( url );
		}
		catch (Exception e){
			// If anything goes wrong, always go to the default login page
			return false;
		}
	}
	
	protected boolean matches( String url ) {
		Matcher matcher = pattern.matcher( url );
		return matcher.matches();
	}

}
