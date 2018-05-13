package com.senla.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class MyLogger implements ILogger {
	public static Logger logger = Logger.getLogger(MyLogger.class.getName());
		public void defaultSeetings() {
		Handler fileHandler;
		try {
			fileHandler = new FileHandler("%h/MyLogger.log");
			fileHandler.setFormatter(new MyFormatter());
			logger.setUseParentHandlers(false);
			logger.addHandler(fileHandler );
		} catch (SecurityException e) {
			logger.info("SecurityException: " + e.getClass());
		} catch (IOException e) {
			logger.info("IOException: " + e.getClass());
		}
	}
}
	class MyFormatter extends Formatter {
		@Override
		public String format(LogRecord record) {
			return 	record.getLevel() + ": " + 
					record.getSourceClassName() + ": " + 
					record.getSourceMethodName() + ": "  + 
					record.getMessage() + "\r\n";
		}
	}
