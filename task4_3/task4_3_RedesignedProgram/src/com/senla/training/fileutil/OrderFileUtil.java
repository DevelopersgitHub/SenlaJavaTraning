package com.senla.training.fileutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.senla.training.*;
import com.senla.training.model.*;

public final class OrderFileUtil implements FileUtilOrder<Order> {
	

	private static final String TEST_FILE = "order.txt";
	private final FileWorker fileWorker;
	
	public OrderFileUtil() {
		fileWorker = new TextFileWorker(TEST_FILE);
	}
	public Order[] readFromFile() throws NumberFormatException, ParseException {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final Order[] result = new Order[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}

	public void writeToFile(final Order[] values) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			lines[i] = toLine(values[i]);
		}
		fileWorker.writeToFile(lines);
	}

	public String toLine(final Order order) {
		if (order == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(order.getOrderID()), 
				String.valueOf(order.getDateExecution()),
				String.valueOf(order.getCost()),
				String.valueOf(order.getState())
			};
		return String.join(";", array);
	}

	private Date parseDate(String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
	
	public Order fromLine(final String line) throws NumberFormatException, ParseException {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");
		Date date = parseDate(parts[1],"dd/MM/yyyy");
		final Order result = new Order(
				Long.valueOf(parts[0]),
				parts[1],
				Long.valueOf(parts[2]),
				parts[3]
			);
		return result;
	}
}
