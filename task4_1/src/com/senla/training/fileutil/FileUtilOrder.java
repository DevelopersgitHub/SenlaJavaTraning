package com.senla.training.fileutil;

import java.text.ParseException;

import com.senla.training.model.Order;

public interface FileUtilOrder<T> {
	

	Order[] readFromFile() throws NumberFormatException, ParseException;

	void writeToFile(final T[] values);

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException;

}
