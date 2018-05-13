package com.senla.store;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.OrderFileUtil;
import com.senla.logger.MyLogger;
import com.senla.model.Order;

public class OrderStore implements IOrderStore {
	final OrderFileUtil util = new OrderFileUtil();
	List<Order> orders = new ArrayList<Order>();
	
	public void addOrder(Order c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		orders.add(c);
	}

	public void removeOrder(Order c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		orders.remove(c);
	}
	
	public Order getOrder() throws NumberFormatException, ParseException {
		Order ord = new Order();
		Order[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				ord = readedValues[0];
			}
		} catch (IOException e) {
			MyLogger.logger.info("Error reading from file");
		}
		return ord;
	}
	
	public Order[] getAllOrder() throws NumberFormatException, ParseException {
		Order[] readedValues = null;
		try {
			readedValues = util.readFromFile();
		} catch (Exception e) {
			MyLogger.logger.info("Error reading from file");
		}
		return readedValues;
	}
	public void saveOrder(Order[] persons) throws NumberFormatException, ParseException, FileNotFoundException {
		if(persons == null) {
			throw new IllegalArgumentException();
		}
		try{
			util.writeToFile(persons);
			throw new IOException();
		}catch(FileNotFoundException e) {
			MyLogger.logger.info("File not found");
		}
		catch(IOException e) {
			MyLogger.logger.info("Error reading from file");
		}
		finally {
			MyLogger.logger.info("Success of writing to a file");
		}
		
	}
}

