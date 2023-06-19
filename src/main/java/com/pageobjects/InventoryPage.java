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
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
	public WebElement btnRemove;
	
	List<String> productList = new ArrayList<>();
	
	// Add the selected item to the cart
	public void AddItem(String itemSelected) {
		GetAllItemName();
		
		for(String itemName : productList) {
			if(itemName.equals(itemSelected)) {
				WebElement btnAddToCart = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[" + productList.indexOf(itemName) + "]"));
				btnAddToCart.click();
			}
		}
	}
	
	// Get all product name
	public void GetAllItemName() {
		productList.add("INDEX ZERO");
		List<WebElement> list = driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]"));
		
		for(WebElement item : list) {
			productList.add(item.getText());
		}
	}

}