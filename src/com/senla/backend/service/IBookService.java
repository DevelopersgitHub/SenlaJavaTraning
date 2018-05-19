package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Book;

public interface IBookService {
	public void addBook(Book book);
	public boolean removeBook(Book book);
	public void update(List<Book> book);
	public Book getBook();
	public Book[] getAllBook();
}