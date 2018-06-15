package com.senla.backend.serialization;

import com.senla.backend.dto.DTO;

public interface ISerializationUtil {
	
	public void serialization(DTO dto);
	public DTO deserialization();
	
}
