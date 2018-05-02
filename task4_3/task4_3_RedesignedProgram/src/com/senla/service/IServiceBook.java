package com.senla.service;

import java.text.ParseException;

import com.senla.model.Book;

public interface IServiceBook {
	public Book[] sortNameBook(Book[] readedValues);
	public Book[] sortDatePublic(Book[] readedValues);
	public Book[] sortCost(Book[] readedValues);
	public Book[] sortPresense(Book[] readedValues);
	public Book getBook() throws NumberFormatException, ParseException;
	public void bookDescription(Book b);
	
}