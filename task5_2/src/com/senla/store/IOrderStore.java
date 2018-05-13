package com.senla.store;

import java.io.FileNotFoundException;
import java.text.ParseException;

import com.senla.model.Order;

public interface IOrderStore {
	public void addOrder(Order c);
	public void removeOrder(Order c);
	public Order getOrder() throws NumberFormatException, ParseException;
	public Order[] getAllOrder() throws NumberFormatException, ParseException;
	public void saveOrder(Order[] persons) throws NumberFormatException, ParseException, FileNotFoundException;
}
