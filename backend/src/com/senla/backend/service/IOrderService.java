package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Order;

public interface IOrderService {
	
	public void addOrder(Order order);
	public void removeOrder(Long id);
	public void updateOrder(Long id, String status, Order[] order);
	public Order getOrder(Order[] order, Long id);
	public List<Order> getAllOrder();
	public Order[] loadOrder();
	public void saveOrder(Order[] orders);
	public List<Order> cloneOrder(Order[] orders);
}
