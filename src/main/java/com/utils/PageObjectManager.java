package com.utils;

import com.pageobjects.HeaderBanner;
import com.pageobjects.LoginPage;

import io.appium.java_client.AppiumDriver;

public class PageObjectManager {
	private AppiumDriver driver;
	private LoginPage loginPage;
	private HeaderBanner headerBanner;
	
	public PageObjectManager(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		loginPage = (loginPage == null) ? new LoginPage(driver) : loginPage;
		return loginPage;
	}
	
	public HeaderBanner getHeaderBanner() {
		headerBanner = (headerBanner == null) ? new HeaderBanner(driver) : headerBanner;
		return headerBanner;
	}
}
