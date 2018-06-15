package com.senla.backend.service;

import java.util.List;

import com.senla.backend.dto.DTO;
import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;

public interface IShop {
	
	public void addBook(Book book);
	public void addOrder(Order order);
	public void addClient(Client client);
	
	public void removeBook(Long id);
	public void removeOrder(Long id);
	public void removeClient(Long id);
	
	public Book getBook(Book[] book, Long id);
	public Order getOrder(Order[] order, Long id);
	public Client getClient(Client[] client, Long id);
	
	public List<Book> getAllBook();
	public List<Order> getAllOrder();
	public List<Client> getAllClient();
	
	public void updateBook(Long id, Book book);
	public void updateOrder(Long id, String status, Order[] order);
	public void updateClient(Long id, Client client);
	
	public Book[] loadBook();
	public void saveBook(Book[] books);
	
	public Order[] loadOrder();
	public void saveOrder(Order[] orders);
	
	public Client[] loadClient();
	public void saveClient(Client[] clients);
	
	public Book[] sortNameBook(Book[] book);
	public Book[] sortDatePublic(Book[] book);
	public Book[] sortCost(Book[] book);
	public Book[] sortPresense(Book[] book);
	public String bookDescription(Book[] book, Long l);
	
	public Order[] sortDateExecution(Order[] order);
	public Order[] sortCostOrder(Order[] order);
	public Order[] sortStatus(Order[] order);
	
	public String orderDetails(Order ordersDetails, Long idOrder);
	public int countCompletedOrder(Order[] oc);
	public double sumOrder(Order[] order);
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
	
	
	public void countMonthWait(Integer month);
	public boolean powerOrdersCompeled(Boolean value);
	
	public List<Order> cloneOrder(Order[] orders);
	
	public void importCSV();
	public void exportCSV();
	
	public void serialization();
	public DTO deserialization();
}
