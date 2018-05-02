package com.senla.store;

import java.util.ArrayList;
import java.util.List;

import com.senla.model.*;

public class Shop implements IShop{
	List<Client> clients;
	List<Order> orders;
	List<Book> books;
	public Shop(){
		super();
		clients = new ArrayList<Client>();
		orders = new ArrayList<Order>();
		books = new ArrayList<Book>();
	}
	public void addClient(Client c) {
		clients.add(c);
	}
	public void removeClient(Client c) {
		clients.remove(c);
	}
	public void addOrder(Order o) {
		orders.add(o);
	}
	public void removeOrder(Order o) {
		orders.remove(o);
	}
	public void addBook(Book o) {
		books.add(o);
	}
	public void removeBook(Book o) {
		books.remove(o);
	}
}
