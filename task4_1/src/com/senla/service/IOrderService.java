package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.model.Order;

public interface IOrderService {
	
	public void addOrder(Order order);
	public boolean removeOrder(Order order);
	public void update(List<Order> order);
	public Order getOrder() throws NumberFormatException, ParseException;
	public Order[] getAllOrder() throws NumberFormatException, ParseException;
}
