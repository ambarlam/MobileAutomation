package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class InventoryPage {
	public InventoryPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	AndroidDriver driver;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
	public static WebElement lblProductName;
	
	@FindBy(how = How.XPATH, using = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
	public WebElement btnAddToCart;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
	public WebElement btnRemove;
	
	public void AddItemToCart()
	{
		btnAddToCart.click();
	}
	
	// Dynamic adding of the item
	public void AddItem(String itemSelected)
	{
		List<String> productList = new ArrayList<String>();
		productList.add(lblProductName.getText());

		for(String itemName : productList)
		{
			if(itemSelected.equals(itemName))
			{
				driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\\\\\\\"test-ADD TO CART\\\\\\\"])[" + productList.indexOf(itemName) + "]")).click();
			}
		}
	}

}

