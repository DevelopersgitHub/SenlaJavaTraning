package com.senla.service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;

import com.senla.fileutil.BookFileUtil;
import com.senla.model.Book;

public class ServiceBook implements IServiceBook{

	public Book[] sortNameBook(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookName().compareTo(o2.getBookName());
				}
			});
		return readedValues;
		}
	
	public Book[] sortDatePublic(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookDatePublic().compareTo(o2.getBookDatePublic());
				}
			});
		return readedValues;
		}
	
	public Book[] sortCost(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookCost().compareTo(o2.getBookCost());
				}
			});
		return readedValues;
		}
	
	public Book[] sortPresense(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookPresence().compareTo(o2.getBookPresence());
				}
			});
		return readedValues;
		}
	final BookFileUtil util = new BookFileUtil();
	public Book getBook() throws NumberFormatException, ParseException {
		Book bk = new Book();
		final Book[] readedValues = util.readFromFile();
		for(int i=0;i<readedValues.length;i++) {
			bk = readedValues[0];
		}
		return bk;
	}
	public void bookDescription(Book bk){
			System.out.println(bk.getBookName() + "\nDescription of books: " + bk.getBookDescription());
		}
	}
