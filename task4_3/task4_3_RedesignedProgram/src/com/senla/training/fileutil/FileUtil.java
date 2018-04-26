package com.senla.training.fileutil;

import java.text.ParseException;

import com.senla.training.model.Book;

public interface FileUtil<T> {
	

	Book[] readFromFile() throws NumberFormatException, ParseException;

	void writeToFile(final T[] values);

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException;

}
