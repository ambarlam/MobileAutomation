package com.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	private static ConfigurationReader configurations;
	private Properties properties;
	
	public ConfigurationReader() {
		try(BufferedReader reader = new BufferedReader(new FileReader(Literals.RESOURCES_PATH + "Configuration.properties"));){
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public String getEnvironmentToRun() {
		return properties.getProperty("ENVIRONMENT_TO_RUN");
	}
	
	public String getPlatformName() {
		return properties.getProperty("PLATFORM_NAME");
	}
	
	public String getAutomationName() {
		return properties.getProperty("AUTOMATION_NAME");
	}
	
	public String getPlatformVersion() {
		return properties.getProperty("PLATFORM_VERSION");
	}
	
	public String getDeviceName() {
		return properties.getProperty("DEVICE_NAME");
	}
	
	public String getAppFileName() {
		return properties.getProperty("APP_FILE_NAME");
	}
	
	public String getSauceUsername() {
		return properties.getProperty("SAUCE_USERNAME");
	}
	
	public String getSauceAccessKey() {
		return properties.getProperty("SAUCE_ACCESS_KEY");
	}
	
	public String getSauceRegion() {
		return properties.getProperty("SAUCE_REGION");
	}
	
	public String getSauceReportsName() {
		return properties.getProperty("SAUCE_REPORTS");
	}
	
	public static ConfigurationReader getConfigurations() {
		return (configurations == null) ? new ConfigurationReader() : configurations;
	}
}
