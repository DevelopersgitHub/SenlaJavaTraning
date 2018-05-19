package com.senla.backend.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.BookFileUtil;
import com.senla.backend.fileutil.IBookFileUtil;
import com.senla.backend.model.Book;

public class BookStore implements IBookStore {
	private static final Logger LOGGER = LogManager.getLogger(BookStore.class.getSimpleName());
	
	final IBookFileUtil<Book> util = new BookFileUtil();
	
	private List<Book> books;

	public BookStore() {
		 books = new ArrayList<Book>();
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book);
		
	}
	
	public void update(List<Book> book) {
		this.books = book;
	}
	
	public Book getBook() {
		Book book = new Book();
		Book[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				book = readedValues[0];
			}
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (ParseException e) {
			LOGGER.error("ParseException" + e.getClass());
		}
		return book;
	}
	
	public Book[] getAllBook() {
		Book[] readedValues = null;
		try {
			readedValues = util.readFromFile();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (ParseException e) {
			LOGGER.error("ParseException" + e.getClass());
		}
		return readedValues;
	}
	
	public void saveBook(Book[] persons) {
		if(persons == null) {
			throw new IllegalArgumentException();
		}
		util.writeToFile(persons);
	}
	
	public boolean removeBook(Book book) {
		 return books.remove(book);
	}

}
