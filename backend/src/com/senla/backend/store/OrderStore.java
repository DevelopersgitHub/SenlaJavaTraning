package com.senla.backend.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.IOrderFileUtil;
import com.senla.backend.fileutil.OrderFileUtil;
import com.senla.backend.model.Order;

public class OrderStore implements IOrderStore, Cloneable {
	private static final Logger LOGGER = LogManager.getLogger(OrderStore.class.getSimpleName());
	
	final IOrderFileUtil<Order> util = new OrderFileUtil();
	
	private List<Order> orders;
	
	public OrderStore() {
		orders = new ArrayList<Order>();
	}
	
	public OrderStore(OrderStore orderStore) {
		
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
	
	public void updateOrder(Long id, String status, Order[] order) {
		for (int i = 0; i < order.length; i++) {
            if(order[i].getID().equals(id)) {
            	order[i].setOrderStatus(status);
            }
        }
	}
	
	public Order getOrder(Order[] order, Long id)  {
		List<Order> list = Arrays.asList(order); 
		return list.stream().filter(p -> p.getID().equals(id)).collect(Collectors.<Order> toList()).get(0); 
	}
	
	public List<Order> getAllOrder(){
		return this.orders;
	}
	
	public void removeOrder(Long id) {
		for(Order order : orders) {
			if(order.getID().equals(id)) {
				orders.remove(order);
				return;
			}
		}
	}
	
	public Order[] loadOrder() {
		Order[] orders = null;
		try {
			orders = util.readFromFile();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return orders;
	}
	
	public void saveOrder(Order[] orders) {
		util.writeToFile(orders);
		
	}

	//method clone() before changes
	 
	public List<Order> cloneOrder(Order[] orders) {
		List<Order> orderList = Arrays.asList(orders);
		List<Order> orderCloneList = new ArrayList<Order>(orderList.size());
		for (Order order : orderList) {
			orderCloneList.add(new Order(order));
	    }
		return orderList;
	}
}

