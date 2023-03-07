package com.utils;

public class Literals {
	// FILE PATH
	public static final String RESOURCES_PATH = "src/test/resources/";
	
	// User Account Credentials
	public static final String VALID_USERNAME = "standard_user";
	public static final String VALID_PASSWORD = "secret_sauce";
	public static final String INVALID_USERNAME = "Test123";
	public static final String INVALID_PASSWORD = "Test123";
	
	// Error messages
	public static final String ERR_USERNAME_REQUIRED = "Username is required";
	public static final String ERR_PASSWORD_REQUIRED = "Password is required";
	public static final String ERR_CREDENTIALS_DONT_MATCH = "Username and password do not match any user in this service.";
	
	// Environments to run
	public static final String SAUCELABS = "SAUCELABS";
	public static final String LOCAL = "LOCAL";
	
	// App configuration constants
	public static String APPIUM_SERVER = "http://localhost:4723/wd/hub";
	public static String appWaitActivity = "com.swaglabsmobileapp.MainActivity";
}
