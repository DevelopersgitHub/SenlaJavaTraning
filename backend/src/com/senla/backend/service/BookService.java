package com.senla.backend.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.BookFileUtil;
import com.senla.backend.fileutil.IBookFileUtil;
import com.senla.backend.model.Book;
import com.senla.backend.store.IBookStore;
import com.senla.di.DI;

public class BookService implements IBookService{
	private static final Logger LOGGER = LogManager.getLogger(BookService.class.getSimpleName());
	
	final IBookFileUtil<Book> util = new BookFileUtil();
	
	private IBookStore bookStore;
	
	public BookService() {
		bookStore = DI.configure(IBookStore.class);
	}
	
	public void addBook(Book book) {
		   bookStore.addBook(book);
	}
		  
	public void removeBook(Long id) {
		  bookStore.removeBook(id);
	}

	public void updateBook(Long id, Book book) {
		  bookStore.updateBook(id, book);
	}

	public Book getBook(Book[] book, Long id) {
		Book books = null;
		try {
			books = bookStore.getBook(bookStore.loadBook(), id);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return books;
	}

	public List<Book> getAllBook() {
		List<Book> book = null;
		try {
			book = bookStore.getAllBook();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return book;
	}
	
	public Book[] loadBook() {
		Book[] books = null;
		try {
			books = bookStore.loadBook();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return books;
	}
	
	public void saveBook(Book[] persons) {
		bookStore.saveBook(persons);
	}
	
}
