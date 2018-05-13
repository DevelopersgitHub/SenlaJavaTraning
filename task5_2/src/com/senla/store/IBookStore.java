package com.senla.store;

import java.text.ParseException;

import com.senla.model.Book;

public interface IBookStore {
	public void addBook(Book c);
	public void removeBook(Book c);
	public Book getBook() throws NumberFormatException, ParseException;
	public Book[] getAllBook() throws NumberFormatException, ParseException;
	public void saveBook(Book[] persons) throws NumberFormatException, ParseException;
}
