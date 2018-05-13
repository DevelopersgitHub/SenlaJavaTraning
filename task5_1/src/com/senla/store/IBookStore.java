package com.senla.store;


import com.senla.model.Book;

public interface IBookStore {
	public void addBook(Book c);
	public void removeBook(Book c);
	public Book getBook();
	public Book[] getAllBook();
	public void saveBook(Book[] persons);
}
