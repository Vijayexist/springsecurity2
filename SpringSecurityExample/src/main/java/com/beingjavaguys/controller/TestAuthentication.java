package com.beingjavaguys.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


@SuppressWarnings("serial")
public class TestAuthentication implements Authentication {
    

    // TFS: Marking isAuthenticated as transient will prevent it from
    // being serialized by Tomcat (which serializes session objects by
    // default). This will force a call on attemptAuthentication and
    // re-establish a CBSV connection when Tomcat is restarted...
	transient private boolean isAuthenticated = false;
	private String username;
	private String password;
	private Long id;
	private String operatorId;
	private AuthenticationDetails details = null;
	private GrantedAuthority[] grantedAuthorityArray;
	
	/**
	 * This constructor is used before authentication.
	 * @param username User Name
	 * @param password Password
	 * @param environmentName Cyborg environment name
	 */
	public TestAuthentication( String username, String password, String environmentName ) {
	    
		this.username = username;
		this.password = password;
        this.details = new AuthenticationDetails(environmentName);
		this.isAuthenticated = false;
		System.out.println("cyborg authentication constructor");
	}
	
	/**
	 * This constructor is used when authentication was successful
	 * @param username User name
	 * @param password password
	 * @param details Details
	 * @param grantedAuthorities Granted Authorities
	 */
	public TestAuthentication( String username, String password, AuthenticationDetails details, GrantedAuthority[] grantedAuthorities ) 
	{
		
		if(this.password=="1234")
		{
		this.password = password;
		this.details = details;
		this.isAuthenticated = true;
		this.grantedAuthorityArray = grantedAuthorities;
		}else
			this.isAuthenticated=false;
	}
	
	 
	public String getEnvironment()
	{
	    return this.details.getEnvironmentName();
	}
	
	public String getName() {
		return username;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = Arrays.asList(grantedAuthorityArray);
		return list;
	}

	public Object getCredentials() {
		return password;
	}

	public AuthenticationDetails getDetails() {
		return this.details;
	}

	public Object getPrincipal() {
		return username;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated( boolean isAuthenticated ) throws IllegalArgumentException {
		if( isAuthenticated ) {
			throw new IllegalArgumentException("true parameter is not valid");
		}
		this.isAuthenticated = isAuthenticated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
}
