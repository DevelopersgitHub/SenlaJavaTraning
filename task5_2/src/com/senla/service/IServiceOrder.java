package com.senla.service;

import java.util.ArrayList;

import com.senla.model.Order;

public interface IServiceOrder {
	public Order[] sortDateExecution(Order[] readedValues);
	public Order[] sortCostOrder(Order[] readedValues);
	public Order[] sortStatus(Order[] readedValues);
	public String orderDetails(Order ord, Long idOrder);
	public int countCompletedOrder(Order[] oc);
	public double sumOrder(Order[] oc);
	public int countRequest(Order[] persons, String str);
	public ArrayList<Integer> sortCountRequest(Integer n1, Integer n2);
	public ArrayList<Order> sortAlphabetically(ArrayList<Order> array);
	public ArrayList<Order> listCompletedOrder(Order[] orderListCompleted);
	public ArrayList<Order> listStaleOrder(Order[] orderListCompleted);
	public ArrayList<Order> sortListCompletedOrderByDate(ArrayList<Order> s);
	public ArrayList<Order> sortListCompletedOrderByCost(ArrayList<Order> s);
	public ArrayList<Order> methodAlphabeticallyForSort(Order[] persons,String str, String str1);
}
