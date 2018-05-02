package com.senla.fileutil;

import java.text.ParseException;

import com.senla.model.*;

public interface IOrderFileUtil<T> {
	

	Order[] readFromFile() throws NumberFormatException, ParseException;

	void writeToFile(final T[] values);

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException;

}
