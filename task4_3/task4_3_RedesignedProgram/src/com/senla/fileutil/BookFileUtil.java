package com.senla.fileutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.senla.model.*;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senla.controller.Main;

public final class BookFileUtil implements IBookFileUtil<Book> {
	

	private static final String TEST_FILE = Main.getFileNameIn();
			
	private final FileWorker fileWorker;
	
	public BookFileUtil() {
		fileWorker = new TextFileWorker(TEST_FILE);
	}
	public Book[] readFromFile() throws NumberFormatException, ParseException {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final Book[] result = new Book[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}

	public void writeToFile(final Book[] values) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			lines[i] = toLine(values[i]);
		}
		fileWorker.writeToFile(lines);
	}

	public String toLine(final Book book) {
		if (book == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(book.getBookID()), 
				book.getBookName(), 
				String.valueOf(book.getBookDatePublic()),
				String.valueOf(book.getBookCost()),
				String.valueOf(book.getBookPresence()),
				book.getBookDescription()
			};
		return String.join(";", array);
	}

	private Date parseDate(String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
	
	public Book fromLine(final String line) throws NumberFormatException, ParseException {
		
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");
		
		Date date;
		@SuppressWarnings("deprecation")
		final Book result = new Book(
				Long.valueOf(parts[0]), 
				parts[1], 
				date = parseDate(parts[2],"dd/MM/yyyy"),
				Double.valueOf(parts[3]),
				Boolean.valueOf(parts[4]),
				parts[5]
			);
		
		return result;
	}
}
