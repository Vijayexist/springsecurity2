package com.beingjavaguys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class DefaultEntryPoint implements AuthenticationEntryPoint 
{

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		System.out.println("default entry point");
		response.sendRedirect("spring_security_login");
		
	}

}
