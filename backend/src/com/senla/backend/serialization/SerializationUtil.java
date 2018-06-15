package com.senla.backend.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.dto.DTO;

public class SerializationUtil implements ISerializationUtil{
	private static final Logger LOGGER = LogManager.getLogger(SerializationUtil.class.getSimpleName());
	
	private static final String path = "temp.out";
	
	public SerializationUtil() {
		
	}

	public void serialization(DTO dto) {
		try (FileOutputStream fos = new FileOutputStream(path);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) 
		{
			oos.writeObject(dto);
			
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
	}
	
	public DTO deserialization() {
		DTO dto = null;
		try (FileInputStream fis = new FileInputStream(path);
			 ObjectInputStream ois = new ObjectInputStream(fis))
		{
			dto = (DTO) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return dto;
	}
}
