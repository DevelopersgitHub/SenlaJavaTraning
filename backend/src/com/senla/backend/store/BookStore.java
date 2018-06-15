package com.senla.backend.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public void addBook(Book book) {
		books.add(book);
		
	}
	
	public void updateBook(Long id, Book book) {
		for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getBookID().equals(id)) {
            	books.set(i, book);
            }
        }
	}
	
	public Book getBook(Book[] book, Long id) { 
		List<Book> list = Arrays.asList(book); 
		return list.stream().filter(p -> p.getBookID().equals(id)).collect(Collectors.<Book> toList()).get(0); 
	}
	
	
	public List<Book> getAllBook() {
		return this.books;
	}
	
	public void removeBook(Long id) {
		this.books.removeIf(p -> p.getBookID().equals(id));
	}
	
	public Book[] loadBook() {
		Book[] books = null;
		try {
			books = util.readFromFile();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return books;
	}
	
	public void saveBook(Book[] persons) {
		util.writeToFile(persons);
	}
	
}
