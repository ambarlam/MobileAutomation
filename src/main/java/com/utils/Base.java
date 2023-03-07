package com.utils;

public class Base {
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	private Waits waits;
	
	public Base() {
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
		waits = new Waits(driverManager.getDriver());
	}
	
	public DriverManager getAndroidDriverManager() {
		return driverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public Waits getWaits() {
		return waits;
	}
}
