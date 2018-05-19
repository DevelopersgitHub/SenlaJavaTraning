package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Order;

public interface IOrderService {
	
	public void addOrder(Order order);
	public boolean removeOrder(Order order);
	public void update(List<Order> order);
	public Order getOrder();
	public Order[] getAllOrder();
}
