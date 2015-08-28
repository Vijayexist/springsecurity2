package com.beingjavaguys.controller;

public class AuthenticationDetails extends Object
{
    private String environmentName;

	public AuthenticationDetails(String environmentName)
    {
		System.out.println("authentication details constructor");
        this.environmentName = environmentName;
    }
    
    public String getEnvironmentName()
    {
        return this.environmentName;
    }
    
    public void setEnvironmentName(String environmentName)
    {
        this.environmentName = environmentName;
    }
}