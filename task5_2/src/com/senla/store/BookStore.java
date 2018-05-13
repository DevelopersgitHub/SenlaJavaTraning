package com.senla.store;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.BookFileUtil;
import com.senla.logger.MyLogger;
import com.senla.model.Book;

public class BookStore implements IBookStore {
	
	List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		books.add(c);
	}

	public void removeBook(Book c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		books.remove(c);
	}

	final BookFileUtil util = new BookFileUtil();
	
	public Book getBook() throws NumberFormatException, ParseException {
		Book bk = new Book();
		Book[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				bk = readedValues[0];
			}
		} catch (IOException e) {
			MyLogger.logger.info("IOException: " + e.getClass());
		}
		return bk;
	}
	public Book[] getAllBook() throws NumberFormatException, ParseException {
		Book[] readedValues = null;
		try {
			readedValues = util.readFromFile();
		} catch (IOException e) {
			MyLogger.logger.info("IOException: " + e.getClass());
		}
		return readedValues;
	}
	public void saveBook(Book[] persons) throws NumberFormatException, ParseException {
		if(persons == null) {
			throw new IllegalArgumentException();
		}
		try {
			util.writeToFile(persons);
		} catch (IOException e) {
			MyLogger.logger.info("IOException: " + e.getClass());
		}
	}
}
