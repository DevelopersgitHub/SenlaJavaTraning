package com.senla.service;

import java.util.ArrayList;
import java.util.List;

import com.senla.model.Order;

public class ServiceClient implements IServiceClient{
	List<Order> order = new ArrayList<Order>();
	public void addOrder(Order o) {
		order.add(o);
	}
}
