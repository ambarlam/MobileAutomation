package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggers {
	Logger logger;
	
	public void logInfo(String...strings) {
		StringBuilder summatedLogs = new StringBuilder();
		
		for(int i=0; i < strings.length; i++) {
			summatedLogs.append(strings[i]);
		}
		
		logger.info(summatedLogs);
	}
	
	public Logger createLogger(String loggerTitle) {
		return logger = LogManager.getLogger(loggerTitle);
	}
	
	public Logger getLogger(String loggerTitle) {
		logger = (logger == null) ? createLogger(loggerTitle) : logger;
		return logger;
	}
}
