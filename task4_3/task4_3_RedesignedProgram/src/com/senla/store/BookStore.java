package com.senla.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.BookFileUtil;
import com.senla.model.Book;

public class BookStore implements IBookStore {
	
	List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book c) {
		books.add(c);
	}

	public void removeBook(Book c) {
		books.remove(c);
	}

	final BookFileUtil util = new BookFileUtil();
	
	public Book getBook() throws NumberFormatException, ParseException {
		Book bk = new Book();
		final Book[] readedValues = util.readFromFile();
		for(int i=0;i<readedValues.length;i++) {
			bk = readedValues[0];
		}
		return bk;
	}
	public Book[] getAllBook() throws NumberFormatException, ParseException {
		final Book[] readedValues = util.readFromFile();
		return readedValues;
	}
	public void saveBook(Book[] persons) throws NumberFormatException, ParseException {
		util.writeToFile(persons);
	}
}
