package com.senla.training.example;

import java.text.ParseException;

public interface FileUtil<T> {
	

	T[] readFromFile() throws NumberFormatException, ParseException;

	void writeToFile(final T[] values);

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException;

}
