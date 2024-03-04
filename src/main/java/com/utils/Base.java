package com.utils;

public class Base {
	private AndroidDriverManager androidDriverManager;
	private PageObjectManager pageObjectManager;
	private Waits waits;
	private Loggers loggers;
	
	public Base() {
		androidDriverManager = new AndroidDriverManager();
		pageObjectManager = new PageObjectManager(androidDriverManager.getDriver());
		waits = new Waits(androidDriverManager.getDriver());
		loggers = new Loggers();
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
	
	public Loggers getLoggers(String loggerTitle) {
		loggers.getLogger(loggerTitle);
		return loggers;
	}
}
