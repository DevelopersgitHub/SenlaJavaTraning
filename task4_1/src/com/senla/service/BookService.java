package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.fileutil.BookFileUtil;
import com.senla.fileutil.IBookFileUtil;
import com.senla.model.Book;
import com.senla.store.BookStore;
import com.senla.store.IBookStore;

public class BookService implements IBookService{

	final IBookFileUtil<Book> util = new BookFileUtil();
	
	private IBookStore bookStore = new BookStore();
	
	public BookService() {
	}
	
	public IBookStore getBookStore() {
		return bookStore;
	}

	public void setBookStore(IBookStore bookStore) {
		this.bookStore = bookStore;
	}

	public void addBook(Book book) {
		   bookStore.addBook(book);
	}
		  
	public boolean removeBook(Book book) {
		  return bookStore.removeBook(book);
	}

	public void update(List<Book> book) {
		this.bookStore = (IBookStore) book;
	}

	public Book getBook() throws NumberFormatException, ParseException {
		Book book = bookStore.getBook();
		return book;
	}

	public Book[] getAllBook() throws NumberFormatException, ParseException {
		Book[] book = bookStore.getAllBook();
		return book;
	}

}
