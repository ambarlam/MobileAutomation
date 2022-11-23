package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Waits {
	AndroidDriver driver;
	
	public Waits(AndroidDriver driver) {
		this.driver = driver;
	}
	
	// Overloaded method with default wait time in seconds as 10
	public void untilElementIsVisible(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	// Overloaded method for customized wait time
	public void untilElementIsVisible(int timeout, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
