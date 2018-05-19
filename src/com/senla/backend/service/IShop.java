package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;

public interface IShop {
	
	public void addBook(Book book);
	public void addOrder(Order order);
	public void addClient(Client client);
	
	public void removeBook(Book book);
	public void removeOrder(Order order);
	public void removeClient(Client client);
	
	
	public Book getBook();
	public Order getOrder();
	public Client getClient();
	
	public Book[] getAllBook();
	public Order[] getAllOrder();
	public Client[] getAllClient();
	
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
	
	public String orderDetails(Order ord, Long idOrder);
	public int countCompletedOrder(Order[] oc);
	public double sumOrder(Order[] oc);
	public int countRequest(Order[] persons, String str);
	public List<Integer> sortCountRequest(Integer n1, Integer n2);
	public List<Order> listCompletedOrder(Order[] orderListCompleted);
	public List<Order> listStaleOrder(Order[] orderListCompleted);
	public List<Order> sortAlphabetically(List<Order> array);
	public List<Order> sortListCompletedOrderByDate(List<Order> s);
	public List<Order> sortListCompletedOrderByCost(List<Order> s);
	public List<Order> methodAlphabeticallyForSort(Order[] persons,String str, String str1);
	public List<Order> sortListUnsoldBookByDate(List<Order> s);
	public List<Order> sortListUnsoldBookByCost(List<Order> s);
	

}
