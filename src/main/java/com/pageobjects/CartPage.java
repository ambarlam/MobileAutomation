package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage {
	public CartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	AndroidDriver driver;
	
	// Checks the Item is added to the cart
	public String ValidateItemIsAdded(String itemName)
	{
		String itemNameXPath = "//android.widget.TextView[@text='" + itemName + "']";
		return driver.findElement(By.xpath(itemNameXPath)).getText();
	}
}