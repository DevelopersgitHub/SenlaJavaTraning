package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Book;

public interface IBookService {
	public void addBook(Book book);
	public void removeBook(Long id);
	public void updateBook(Long id, Book book) ;
	public Book getBook(Book[] book, Long id);
	public List<Book> getAllBook();
	public Book[] loadBook();
	public void saveBook(Book[] persons);
}