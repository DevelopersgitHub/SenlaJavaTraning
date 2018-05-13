package com.senla.service;

import com.senla.model.Book;

public interface IServiceBook {
	public Book[] sortNameBook(Book[] readedValues);
	public Book[] sortDatePublic(Book[] readedValues);
	public Book[] sortCost(Book[] readedValues);
	public Book[] sortPresense(Book[] readedValues);
	public Book getBook();
	public String bookDescription(Book b, long l);
	
}