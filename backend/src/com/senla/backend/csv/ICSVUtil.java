package com.senla.backend.csv;

import java.util.List;

import com.senla.backend.model.Book;

public interface ICSVUtil {
	
	public List<Book> importCSV();
	
	public void exportCSV(Book book);
	
	
}
