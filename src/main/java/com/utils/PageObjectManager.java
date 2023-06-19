package com.utils;

import com.pageobjects.HeaderBanner;
import com.pageobjects.LoginPage;
import com.pageobjects.InventoryPage;
import com.pageobjects.CartPage;

import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {
	private AndroidDriver driver;
	private LoginPage loginPage;
	private HeaderBanner headerBanner;
	private InventoryPage inventoryPage;
	private CartPage cartPage;
	
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
	
	public InventoryPage getInventoryPage()
	{
		inventoryPage = (inventoryPage == null) ? new InventoryPage(driver) : inventoryPage;
		return inventoryPage;
	}
	
	public CartPage getCartPage()
	{
		cartPage = (cartPage == null) ? new CartPage(driver) : cartPage;
		return cartPage;
	}
}
