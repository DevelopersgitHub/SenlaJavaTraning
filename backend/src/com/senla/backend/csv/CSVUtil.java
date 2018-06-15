package com.senla.backend.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.controller.Main;
import com.senla.backend.model.Book;


public class CSVUtil implements ICSVUtil{
	private static final Logger LOGGER = LogManager.getLogger(Main.class.getSimpleName());
	private static final File PATH_TO_FILE_CSV = new File("storage.csv");

	public List<Book> importCSV() {
		String line = "";
		String[] books = null;
		List<Book> bookList = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(PATH_TO_FILE_CSV))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				books = line.split(";");
				Book book;
				DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
				book = new Book(Long.parseLong(books[0]), books[1], dateFormat.parse(books[2]), Double.parseDouble(books[3]), Boolean.parseBoolean(books[4]), books[5]);
				bookList.add(book);
			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch(IOException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return bookList;
	}
	
	public void exportCSV(Book books) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_TO_FILE_CSV))) {
		
				bw.append(String.valueOf(books.getBookID()));
				bw.append(";");
				bw.append(String.valueOf(books.getBookName()));
				bw.append(";");
				DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
				bw.append(dateFormat.format(books.getBookDatePublic()));
				bw.append(";");
				bw.append(String.valueOf(books.getBookCost()));
				bw.append(";");
				bw.append(String.valueOf(books.getBookPresence()));
				bw.append(";");
				bw.append(String.valueOf(books.getBookDescription()));
				bw.append("\n");
		
		} catch(IOException e) {
			LOGGER.error(e.getMessage(),  e);
		}
        
	}
	
	public static Date parseDate (String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}

}
