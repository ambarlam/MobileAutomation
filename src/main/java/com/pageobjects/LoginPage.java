package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	public LoginPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]")
	public WebElement imgSwagLabs;
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	private WebElement txtUsername;
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	private WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	private WebElement btnLogin;
	
	public void login(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
