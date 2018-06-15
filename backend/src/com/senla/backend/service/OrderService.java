package com.senla.backend.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.IOrderFileUtil;
import com.senla.backend.fileutil.OrderFileUtil;
import com.senla.backend.model.Order;
import com.senla.backend.store.IOrderStore;
import com.senla.di.DI;

public class OrderService implements IOrderService {

	private static final Logger LOGGER = LogManager.getLogger(OrderService.class.getSimpleName());
	
	final IOrderFileUtil<Order> util = new OrderFileUtil();
	
	private IOrderStore orderStore;
	
	public OrderService() {
		orderStore = DI.configure(IOrderStore.class);
	}
	

	public void addOrder(Order order) {
		 orderStore.addOrder(order);
		
	}

	public void removeOrder(Long id) {
		orderStore.removeOrder(id);
	}

	public void updateOrder(Long id, String status, Order[] order) {
		orderStore.updateOrder(id, status, order);
		
	}

	public Order getOrder(Order[] orders, Long id) {
		Order order = null;
		try {
			order = orderStore.getOrder(orders, id);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return order;
	}

	public List<Order> getAllOrder() {
		List<Order> order = null;
		try {
			order = orderStore.getAllOrder();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return order;
	}

	public Order[] loadOrder() {
		Order[] orders = null;
		try {
			orders = orderStore.loadOrder();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return orders;
	}

	public void saveOrder(Order[] orders) {
		orderStore.saveOrder(orders);
		
	}

	public List<Order> cloneOrder(Order[] orders) {
		List<Order> orderList = orderStore.cloneOrder(orders);
		return orderList;
	}

}


