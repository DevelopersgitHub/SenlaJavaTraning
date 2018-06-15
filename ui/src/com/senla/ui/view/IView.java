package com.senla.ui.view;


import java.util.List;

import com.senla.backend.dto.DTO;
import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;

public interface IView {
	public void addBook(Book book);
	public void getBook(Book books);
	public void getAllBook(List<Book> book);
	public void updateBook(Book book);
	public void removeBook(Book book);
	
	public void addOrder(Order Order);
	public void getOrder(Order orders);
	public void getAllOrder(List<Order> order);
	public void updateOrder(Order orders);
	public void removeOrder(Long id);
	
	public void addClient(Client client);
	public void getClient(Client client);
	public void getAllClient(List<Client> client);
	public void updateClient(Client client);
	public void removeClient(Client client);

	public void loadBook(Book[] book);
	public void loadOrder(Order[] order);
	public void loadClient(Client[] client);
	
	public void saveBook(Book[] book);
	public void saveOrder(Order[] order);
	public void saveClient(Client[] client);
	
	public void showBooks(Book[] books);
	public void showOrders(Order[] orders);
	public void showClients(Client[] clients);
	
	public void showSortNameBook(Book[] booksSort);
	public void showSortDatePublicBook(Book[] booksSort);
	public void showSortCostBook(Book[] booksSort);
	public void showSortPresenceBook(Book[] booksSort);
	public void showBookDescription(String s);
	
	public void showSortDateExecutionOrder(Order[] orderSort);
	public void showSortCostOrder(Order[] orderSort);
	public void showSortStatusOrder(Order[] orderSort);
	public void showOrderDetails(String s);
	
	public void showListCompletedOrders(List<Order> s);
	public void showCountCompletedOrders(int count);
	public void showSortListCompletedOrderByDate(List<Order> s);
	public void showSortListCompletedOrderByCost(List<Order> s);
	
	public void showSumOrders(double sum);
	
	public void showCountRequestBooks(Integer n1, Integer n2, String str, String str1);
	public void showSortCountRequestBooks(List<Integer> array);
	public void showSortAlphRequestBooks(List<Order> array);
	
	public void orderListStaleBook(List<Order> list);
	
	public void showCloneOrder(Order[] orderClone);
	public void showImport(List<Book> csvFile);
	public void showExport();
	
	public void showSerialization();
	public void showDeserialization(DTO bookSerial);
}
