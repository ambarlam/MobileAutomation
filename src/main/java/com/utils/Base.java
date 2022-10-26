package com.utils;

public class Base {
	private AndroidDriverManager androidDriverManager;
	private PageObjectManager pageObjectManager;
	private Waits waits;
	
	public Base() {
		androidDriverManager = new AndroidDriverManager();
		pageObjectManager = new PageObjectManager(androidDriverManager.getDriver());
		waits = new Waits(androidDriverManager.getDriver());
	}
	
	public AndroidDriverManager getAndroidDriverManager() {
		return androidDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public Waits getWaits() {
		return waits;
	}
}
