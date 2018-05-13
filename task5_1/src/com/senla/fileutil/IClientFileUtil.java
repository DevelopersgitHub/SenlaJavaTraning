package com.senla.fileutil;

import java.io.IOException;
import java.text.ParseException;

import com.senla.model.Client;

public interface IClientFileUtil<T> {
	

	Client[] readFromFile() throws NumberFormatException, ParseException, IOException;

	void writeToFile(final T[] values);

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException, IOException;

}
