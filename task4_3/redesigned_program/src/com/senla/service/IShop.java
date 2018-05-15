package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;

public interface IShop {
	
	public void addBook(Book book);
	public void addOrder(Order order);
	public void addClient(Client client);
	
	public void removeBook(Book book);
	public void removeOrder(Order order);
	public void removeClient(Client client);
	
	
	public Book getBook() throws NumberFormatException, ParseException;
	public Order getOrder() throws NumberFormatException, ParseException;
	public Client getClient() throws NumberFormatException, ParseException;
	
	public Book[] getAllBook() throws NumberFormatException, ParseException;
	public Order[] getAllOrder() throws NumberFormatException, ParseException;
	public Client[] getAllClient() throws NumberFormatException, ParseException;
	
	public void updateBook(Book book);
	public void updateOrder(Order order);
	public void updateClient(Client client);
	
	public Book[] sortNameBook(Book[] readedValues);
	public Book[] sortDatePublic(Book[] readedValues);
	public Book[] sortCost(Book[] readedValues);
	public Book[] sortPresense(Book[] readedValues);
	public String bookDescription(Book b, long l);
	
	public Order[] sortDateExecution(Order[] readedValues);
	public Order[] sortCostOrder(Order[] readedValues);
	public Order[] sortStatus(Order[] readedValues);
	
	public String orderDetails(Order ord, Long idOrder) throws NumberFormatException, ParseException;
	public int countCompletedOrder(Order[] oc) throws NumberFormatException, ParseException;
	public double sumOrder(Order[] oc) throws ParseException;
	public int countRequest(Order[] persons, String str);
	public List<Integer> sortCountRequest(Integer n1, Integer n2);
	public List<Order> listCompletedOrder(Order[] orderListCompleted) throws ParseException;
	public List<Order> listStaleOrder(Order[] orderListCompleted) throws ParseException;
	public List<Order> sortAlphabetically(List<Order> array);
	public List<Order> sortListCompletedOrderByDate(List<Order> s);
	public List<Order> sortListCompletedOrderByCost(List<Order> s);
	public List<Order> methodAlphabeticallyForSort(Order[] persons,String str, String str1);
	public List<Order> sortListUnsoldBookByDate(List<Order> s);
	public List<Order> sortListUnsoldBookByCost(List<Order> s);
	

}
