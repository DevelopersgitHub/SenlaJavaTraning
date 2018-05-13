package com.senla.store;

import com.senla.model.Order;

public interface IOrderStore {
	public void addOrder(Order c);
	public void removeOrder(Order c);
	public Order getOrder();
	public Order[] getAllOrder();
	public void saveOrder(Order[] persons);
}
