package com.senla.service;

import com.senla.model.Order;

public interface IServiceOrder {
	public Order[] sortDateExecution(Order[] readedValues);
	public Order[] sortCostOrder(Order[] readedValues);
	public Order[] sortStatus(Order[] readedValues);
	public Order orderDetails();
	public void orderDetails(Order ord);
	public int countCompletedOrder(Order[] oc);
	public double sumOrder(Order[] oc);
	public int countRequest(Order[] persons, String str);
	public void sortCountRequest(Integer n1, Integer n2);
	public void sortAlphabetically(Order[] persons,String str);
	public void listCompletedOrder(Order[] orderListCompleted);
	public void listStaleOrder(Order[] orderListCompleted);
}
