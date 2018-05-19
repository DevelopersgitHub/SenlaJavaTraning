package com.senla.backend.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.BookFileUtil;
import com.senla.backend.fileutil.IBookFileUtil;
import com.senla.backend.model.Book;
import com.senla.backend.store.BookStore;
import com.senla.backend.store.IBookStore;

public class BookService implements IBookService{
	private static final Logger LOGGER = LogManager.getLogger(BookService.class.getSimpleName());
	
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

	public Book getBook() {
		Book book = null;
		try {
			book = bookStore.getBook();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		return book;
	}

	public Book[] getAllBook() {
		Book[] book = null;
		try {
			book = bookStore.getAllBook();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		return book;
	}
}
