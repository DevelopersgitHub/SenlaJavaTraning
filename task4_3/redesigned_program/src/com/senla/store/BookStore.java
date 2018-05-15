package com.senla.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.BookFileUtil;
import com.senla.fileutil.IBookFileUtil;
import com.senla.model.Book;

public class BookStore implements IBookStore {
	
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
	
	public Book getBook() throws NumberFormatException, ParseException  {
		Book book = new Book();
		Book[] readedValues = util.readFromFile();
				for(int i=0;i<readedValues.length;i++) {
					book = readedValues[0];
				}
				return book;
	}
	
	public Book[] getAllBook() throws NumberFormatException, ParseException {
		Book[] readedValues = util.readFromFile();
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
