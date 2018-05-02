package com.senla.service;

import java.text.ParseException;

import com.senla.model.Order;

public interface IServiceOrder {
	public Order[] sortDateExecution(Order[] readedValues);
	public Order[] sortCostOrder(Order[] readedValues);
	public Order[] sortStatus(Order[] readedValues);
	public Order orderDetails() throws NumberFormatException, ParseException;
	public void orderDetails(Order ord);
	public int countCompletedOrder(Order[] oc) throws NumberFormatException, ParseException;
	public double sumOrder(Order[] oc) throws ParseException;
	public int countRequest(Order[] persons, String str);
	public void sortCountRequest(Integer n1, Integer n2);
	public void sortAlphabetically(Order[] persons,String str);
	public void listCompletedOrder(Order[] orderListCompleted) throws ParseException;
	public void listStaleOrder(Order[] orderListCompleted) throws ParseException;
}
