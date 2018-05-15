package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.model.Book;

public interface IBookService {
	public void addBook(Book book);
	public boolean removeBook(Book book);
	public void update(List<Book> book);
	public Book getBook() throws NumberFormatException, ParseException;
	public Book[] getAllBook() throws NumberFormatException, ParseException;
}