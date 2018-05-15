package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.fileutil.IOrderFileUtil;
import com.senla.fileutil.OrderFileUtil;
import com.senla.model.Order;
import com.senla.store.IOrderStore;
import com.senla.store.OrderStore;

public class OrderService implements IOrderService {
	
	final IOrderFileUtil<Order> util = new OrderFileUtil();
	
	private IOrderStore orderStore;
	
	public OrderService() {
		orderStore = new OrderStore();
	}
	
	public IOrderStore getOrderService() {
		return orderStore;
	}

	public void setOrderService(IOrderStore orderService) {
		this.orderStore = orderService;
	}

	public void addOrder(Order order) {
		 orderStore.addOrder(order);
		
	}

	public boolean removeOrder(Order order) {
		return orderStore.removeOrder(order);
	}

	public void update(List<Order> order) {
		orderStore.update(order);
		
	}

	public Order getOrder() throws NumberFormatException, ParseException {
		Order order = orderStore.getOrder();
		return order;
	}

	public Order[] getAllOrder() throws NumberFormatException, ParseException {
		Order[] order = orderStore.getAllOrder();
		return order;
	}

}


