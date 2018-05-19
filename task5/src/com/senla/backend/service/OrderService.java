package com.senla.backend.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.IOrderFileUtil;
import com.senla.backend.fileutil.OrderFileUtil;
import com.senla.backend.model.Order;
import com.senla.backend.store.IOrderStore;
import com.senla.backend.store.OrderStore;

public class OrderService implements IOrderService {

	private static final Logger LOGGER = LogManager.getLogger(OrderService.class.getSimpleName());
	
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

	public Order getOrder() {
		Order order = null;
		try {
			order = orderStore.getOrder();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		return order;
	}

	public Order[] getAllOrder() {
		Order[] order = null;
		try {
			order = orderStore.getAllOrder();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		return order;
	}

}


