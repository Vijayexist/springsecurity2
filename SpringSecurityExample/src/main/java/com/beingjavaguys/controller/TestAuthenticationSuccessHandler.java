package com.beingjavaguys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


/**
 * 
 * @author tsherburne
 *
 */
public class TestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler 
{ 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
		throws IOException, ServletException {
		try {
				super.onAuthenticationSuccess(request, response, authentication);
				System.out.println("TestAuthenticationSuccessHandler authentication success handler");
				postLogin();
			 
		} catch (Throwable t) {
			 t.printStackTrace();
		}
	}

	private void postLogin() {
		System.out.println("Post login method");
		
	}
}
