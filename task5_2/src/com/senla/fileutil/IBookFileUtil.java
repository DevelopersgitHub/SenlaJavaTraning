package com.senla.fileutil;

import java.io.IOException;
import java.text.ParseException;

import com.senla.model.Book;

public interface IBookFileUtil<T> {
	

	Book[] readFromFile() throws NumberFormatException, ParseException, IOException;

	void writeToFile(final T[] values) throws IOException;

	String toLine(T entity);

	T fromLine(String line) throws NumberFormatException, ParseException;

}
