package com.senla.backend.store;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.IOrderFileUtil;
import com.senla.backend.fileutil.OrderFileUtil;
import com.senla.backend.model.Order;

public class OrderStore implements IOrderStore {
	private static final Logger LOGGER = LogManager.getLogger(OrderStore.class.getSimpleName());
	
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
	
	public Order getOrder()  {
		Order order = new Order();
		Order[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				order = readedValues[0];
			}
		}catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (ParseException e) {
			LOGGER.error("ParseException" + e.getClass());
		}
		return order;
	}
	
	public Order[] getAllOrder(){
		Order[] readedValues = null;
		try {
			readedValues = util.readFromFile();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (ParseException e) {
			LOGGER.error("ParseException" + e.getClass());
		}
		return readedValues;
	}
	public boolean removeOrder(Order order) {
		 return orders.remove(order);
	}
	
}

