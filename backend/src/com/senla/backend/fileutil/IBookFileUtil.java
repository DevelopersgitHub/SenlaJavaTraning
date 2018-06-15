package com.senla.backend.fileutil;

import java.text.ParseException;

import com.senla.backend.model.Book;

public interface IBookFileUtil<T> {
	

	Book[] readFromFile() throws NumberFormatException, ParseException;

	void writeToFile(final T[] values);

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException;

}
