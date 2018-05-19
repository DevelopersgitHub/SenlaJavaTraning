package com.senla.backend.store;

import java.util.List;

import com.senla.backend.model.Book;

public interface IBookStore {
	public void addBook(Book book);
	public boolean removeBook(Book book);
	public void update(List<Book> book);
	public Book getBook();
	public Book[] getAllBook();
}
