package com.senla.annotation;

import java.lang.reflect.Field;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.configuration.Config;

public class ConfigAnnotation {
	private static final Logger LOGGER = LogManager.getLogger(ConfigAnnotation.class.getSimpleName());
	
	public static void loadAnnotation(Object object) {
		Class<? extends Object> configAnnotation = object.getClass();
		Field[] fields = configAnnotation.getDeclaredFields();
		for(Field field : fields) {
		if(field.isAnnotationPresent(ConfigProperty.class)) {
			ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);
			String value = Config.configure(configProperty.configName(), configProperty.propertyName());
			try {
				boolean access = field.isAccessible();
				field.setAccessible(true);
				
				if(configProperty.type().equals(Integer.class)) {
					field.setInt(object, Integer.valueOf(value));
				}
				else if(configProperty.type().equals(Boolean.class)){
					field.setBoolean(object, Boolean.valueOf(value));
				}
				else if(configProperty.type().equals(Double.class)){
					field.setDouble(object, Double.valueOf(value));
				}
				else if(configProperty.type().equals(String.class)) {
					field.set(object, value);
				}
				
				field.setAccessible(access);
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
					LOGGER.error(e.getMessage(),  e);
			}
			}
		}
	}
}


