package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HeaderBanner {
	public HeaderBanner(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement icnMenu;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup")
	public WebElement btnCart;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup")
	public WebElement cartBadge;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
	public WebElement btnCheckout;
	
	public void ViewCart() {
		btnCart.click();
	}
}
