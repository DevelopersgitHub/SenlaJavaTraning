package com.senla.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.OrderFileUtil;
import com.senla.model.Order;

public class OrderStore implements IOrderStore {

	final OrderFileUtil util = new OrderFileUtil();
	List<Order> orders = new ArrayList<Order>();
	
	public void addOrder(Order c) {
		orders.add(c);
	}

	public void removeOrder(Order c) {
		orders.remove(c);
	}
	
	public Order getOrder() throws NumberFormatException, ParseException {
		Order ord = new Order();
		final Order[] readedValues = util.readFromFile();
		for(int i=0;i<readedValues.length;i++) {
			ord = readedValues[0];
		}
		return ord;
	}
	
	public Order[] getAllOrder() throws NumberFormatException, ParseException {
		final Order[] readedValues = util.readFromFile();
		return readedValues;
	}
	public void saveOrder(Order[] persons) throws NumberFormatException, ParseException {
		util.writeToFile(persons);
	}
}

