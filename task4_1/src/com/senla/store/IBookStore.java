package com.senla.store;

import java.text.ParseException;
import java.util.List;

import com.senla.model.Book;

public interface IBookStore {
	public void addBook(Book book);
	public boolean removeBook(Book book);
	public void update(List<Book> book);
	public Book getBook() throws NumberFormatException, ParseException;
	public Book[] getAllBook() throws NumberFormatException, ParseException;
}
