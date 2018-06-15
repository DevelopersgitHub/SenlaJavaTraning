package com.senla.di;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.configuration.Config;

public class DI {
	private static final Logger LOGGER = LogManager.getLogger(DI.class.getSimpleName());
	
	private static Map<Class<?>, Object> mapToDI = new HashMap<Class<?>, Object>();
	
	public static <T> T configure(Class<T> c) {
		String name = c.getName();
		T o = null;
		if(mapToDI.containsKey(name)) {
			return (T) mapToDI.get(name);
		}
		else {
			try {
				Properties value = Config.configure("di.properties");
				if(value.getProperty(name) != null) {
					Class<?> s = Class.forName(value.getProperty(name));
					o = (T) s.newInstance();
					mapToDI.put(s, o);
					return o;
				}
				
				} catch (InstantiationException e) {
					LOGGER.error(e.getMessage(),  e);
				} catch (IllegalAccessException e) {
					LOGGER.error(e.getMessage(),  e);
				} catch (IllegalArgumentException e) {
					LOGGER.error(e.getMessage(),  e);
				} catch (SecurityException e) {
					LOGGER.error(e.getMessage(),  e);
				} catch (ClassNotFoundException e) {
				LOGGER.error(e.getMessage(),  e);
			}
		}
		return o;
	}
}
