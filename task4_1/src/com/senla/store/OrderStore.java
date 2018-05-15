package com.senla.store;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import com.senla.fileutil.IOrderFileUtil;
import com.senla.fileutil.OrderFileUtil;
import com.senla.model.Order;

public class OrderStore implements IOrderStore {
	
	final IOrderFileUtil<Order> util = new OrderFileUtil();
	
	private List<Order> orders;
	
	public OrderStore() {
		orders = new ArrayList<Order>();
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
		
	}
	
	public void update( List<Order> order) {
		this.orders = order;
	}
	
	public Order getOrder() throws NumberFormatException, ParseException  {
		Order order = new Order();
		Order[] readedValues = util.readFromFile();
				for(int i=0;i<readedValues.length;i++) {
					order = readedValues[0];
				}
				return order;
	}
	
	public Order[] getAllOrder() throws NumberFormatException, ParseException {
		Order[] readedValues = util.readFromFile();
		return readedValues;
	}
	public boolean removeOrder(Order order) {
		 return orders.remove(order);
	}
	
}

