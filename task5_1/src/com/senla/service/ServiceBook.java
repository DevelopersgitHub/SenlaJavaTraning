package com.senla.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;

import com.senla.controller.Main;
import com.senla.fileutil.BookFileUtil;
import com.senla.logger.MyLogger;
import com.senla.model.Book;

public class ServiceBook  implements IServiceBook {
	
	public Book[] sortNameBook(Book[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookName().compareTo(o2.getBookName());
				}
			});
		return readedValues;
		
		}
	
	public Book[] sortDatePublic(Book[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookDatePublic().compareTo(o2.getBookDatePublic());
				}
			});
		return readedValues;
		}
	
	public Book[] sortCost(Book[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookCost().compareTo(o2.getBookCost());
				}
			});
		return readedValues;
		}
	
	public Book[] sortPresense(Book[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookPresence().compareTo(o2.getBookPresence());
				}
			});
		return readedValues;
		}
	
	final BookFileUtil util = new BookFileUtil();
	public Book getBook() {
		Book bk = new Book();
		Book[] readedValues;
		
			try {
				readedValues = util.readFromFile();
				for(int i=0;i<readedValues.length;i++) {
					bk = readedValues[0];
				}
			} catch (NumberFormatException e) {
				MyLogger.logger.info("NumberFormatException: " + e.getClass());
			} catch (ParseException e) {
				MyLogger.logger.info("ParseException: " + e.getClass());
			} catch (IOException e) {
				MyLogger.logger.info("IOException: " + e.getClass());
			}
		return bk;
	}
	public void bookDescription(Book bk){
		if (bk == null) {
			throw new IllegalArgumentException();
		}
			System.out.println(bk.getBookName() + "\nDescription of books: " + bk.getBookDescription());
	}
}