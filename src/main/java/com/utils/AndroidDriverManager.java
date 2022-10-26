package com.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverManager {
	private static final String SWAG_LABS = "C://Users/anamarie.barlam/Documents/Mobile-Test-Automation/Setup/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
	private static final String APPIUM_SERVER = "http://localhost:4723/wd/hub";
	
	private AndroidDriver driver;
	
	private  AndroidDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel 4 API 29");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability(SWAG_LABS, false);
		capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", SWAG_LABS);
		
		try {
			driver = new AndroidDriver(new URL(APPIUM_SERVER), capabilities);
		} catch (MalformedURLException e) {
			// TODO: handle exception
		}
		return driver;
	}
	
	public AndroidDriver getDriver() {
		driver = (driver == null) ? createDriver() : driver;
		return driver;
	}
	
	public void quitDriver() {
		driver.quit();
	}
}
