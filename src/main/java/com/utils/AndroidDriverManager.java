package com.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverManager {
	private AndroidDriver driver;
	
	private DesiredCapabilities setCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String deviceName = "Pixel 4 API 29";
		String platformName = "Android";
		String platformVersion = "10.0";
		String appWaitActivity = "com.swaglabsmobileapp.MainActivity";
		String automationName = "UiAutomator2";
		
		File file = new File("src/test/resources/SauceLabs.Sample.App.2.7.1.apk");
		String SWAG_LABS = file.getAbsolutePath();
		
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("appWaitActivity", appWaitActivity);
		capabilities.setCapability("automationName", automationName);
		capabilities.setCapability("app", SWAG_LABS);
		
		return capabilities;
	}
	
	private AndroidDriver createDriver() {
		final String APPIUM_SERVER = "http://localhost:4723/wd/hub";
		
		try {
			driver = new AndroidDriver(new URL(APPIUM_SERVER), setCapabilities());
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
