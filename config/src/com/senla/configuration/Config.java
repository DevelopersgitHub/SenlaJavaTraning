package com.senla.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {
	private static final Logger LOGGER = LogManager.getLogger(Config.class.getSimpleName());
	
	public static Map<String, Properties> mapProperties = new HashMap<String, Properties>();

	public static Properties configure(String path) {
		if(mapProperties.containsKey(path)) {
			return mapProperties.get(path);
		}
		Properties properties = new Properties();
		try(FileInputStream stream = new FileInputStream(new File(path))) {
			properties.load(stream);
			mapProperties.put(path, properties);
			return properties;
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return properties;	
	}
	
	public static String configure(String path, String key) {
		Properties properties = configure(path);
		return properties.getProperty(key);
	}
}
