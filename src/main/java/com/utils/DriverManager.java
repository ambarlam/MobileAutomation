package com.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager {
	private AppiumDriver driver;
	
	private String setApplicationName() {
		String SWAG_LABS = "";
		if(ConfigurationReader.getConfigurations().getEnvironmentToRun().equalsIgnoreCase(Literals.LOCAL)) {
			File file = new File(Literals.RESOURCES_PATH + ConfigurationReader.getConfigurations().getAppFileName());
			SWAG_LABS = file.getAbsolutePath();
		} else if(ConfigurationReader.getConfigurations().getEnvironmentToRun().equalsIgnoreCase(Literals.SAUCELABS)){
			SWAG_LABS = "storage:filename=" + ConfigurationReader.getConfigurations().getAppFileName();
		}
		return SWAG_LABS;
	}
	
	private DesiredCapabilities setSauceLabsOptions() {
		DesiredCapabilities sauceOptions = new DesiredCapabilities();
		sauceOptions.setCapability("name", ConfigurationReader.getConfigurations().getSauceReportsName());
		return sauceOptions;
	}
	
	private DesiredCapabilities setCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", ConfigurationReader.getConfigurations().getPlatformName());
		capabilities.setCapability("deviceName", ConfigurationReader.getConfigurations().getDeviceName());
		capabilities.setCapability("platformVersion", ConfigurationReader.getConfigurations().getPlatformVersion());
		capabilities.setCapability("appWaitActivity", Literals.appWaitActivity);
		capabilities.setCapability("automationName", ConfigurationReader.getConfigurations().getAutomationName());
		capabilities.setCapability("app", setApplicationName());
		
		if(ConfigurationReader.getConfigurations().getEnvironmentToRun().equalsIgnoreCase(Literals.SAUCELABS)) {
			capabilities.setCapability("sauce:options", setSauceLabsOptions());
		}
		return capabilities;
	}
	
	private AppiumDriver createDriver() {
		String url = "";
		
		// TODO: variables should be non case sensitive
		switch(ConfigurationReader.getConfigurations().getEnvironmentToRun()) {
		case Literals.LOCAL:
			url = Literals.APPIUM_SERVER;
			break;
		case Literals.SAUCELABS:
			url = "https://" + ConfigurationReader.getConfigurations().getSauceUsername() + ":" 
					+ ConfigurationReader.getConfigurations().getSauceAccessKey() 
					+ ConfigurationReader.getConfigurations().getSauceRegion() + "/wd/hub";
			break;
		default:
			// TODO: Decent default message
			System.out.println("");
		}
		
		try {
			if(ConfigurationReader.getConfigurations().getPlatformName().equals("ios")) {
				driver = new IOSDriver(new URL(url), setCapabilities());
			} else {
				driver = new AndroidDriver(new URL(url), setCapabilities());
			}
		} catch (MalformedURLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return driver;
	}
	
	public AppiumDriver getDriver() {
		driver = (driver == null) ? createDriver() : driver;
		return driver;
	}
	
	public void quitDriver() {
		driver.quit();
	}
}