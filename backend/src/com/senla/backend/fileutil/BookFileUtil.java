package com.senla.backend.fileutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.senla.backend.model.*;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;


public final class BookFileUtil implements IBookFileUtil<Book> {
	
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
				String.valueOf(book.getBookID()), 
				book.getBookName(), 
				String.valueOf(book.getBookDatePublic()),
				String.valueOf(book.getBookCost()),
				String.valueOf(book.getBookPresence()),
				book.getBookDescription()
			};
		return String.join(";", array);
	}

	public Book fromLine(final String line) throws NumberFormatException, ParseException {
		
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");
		
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		final Book result = new Book(
				Long.valueOf(parts[0]), 
				parts[1], 
				dateFormat.parse(parts[2]),
				Double.valueOf(parts[3]),
				Boolean.valueOf(parts[4]),
				parts[5]
			);
		
		return result;
	}
}
