package com.utils;

import com.pageobjects.HeaderBanner;
import com.pageobjects.LoginPage;

import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {
	private AndroidDriver driver;
	private LoginPage loginPage;
	private HeaderBanner headerBanner;
	
	public PageObjectManager(AndroidDriver driver) {
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
