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
	
	public void untilElementIsVisible(int timeout, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
