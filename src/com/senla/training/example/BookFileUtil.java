package com.senla.training.example;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;


public final class BookFileUtil implements FileUtil<Book> {
	

	private static final String TEST_FILE = "books.txt";
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
				String.valueOf(book.getId()), 
				book.getNameBook(), 
				String.valueOf(book.getDatePublic()),
				String.valueOf(book.getCost()),
				String.valueOf(book.getPresence()) 
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
		Date date = parseDate(parts[2],"dd/MM/yyyy");
		final Book result = new Book(
				Long.valueOf(parts[0]), 
				parts[1], 
				parts[2],
				Double.valueOf(parts[3]),
				Long.valueOf(parts[4])
			);
		
		return result;
	}
}
