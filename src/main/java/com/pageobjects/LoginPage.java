package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginPage {
	public LoginPage(AppiumDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	public WebElement txtUsername;
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	private WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	private WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	public WebElement txtErrorMessage;
	
	public void login(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getErrorMessage() {
		return txtErrorMessage.getText();
	}
}
