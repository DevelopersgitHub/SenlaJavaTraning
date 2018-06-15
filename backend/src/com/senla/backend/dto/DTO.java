package com.senla.backend.dto;

import java.io.Serializable;
import java.util.List;

import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;

public class DTO implements Serializable {
	
	private static final long serialVersionUID = -1401446077121305148L;
	
	private List<Book> books;
	private List<Order> orders;
	private List<Client> clients;
	
	public DTO(List<Book> books, List<Order> orders, List<Client> clients) {
		this.books = books;
		this.orders = orders;
		this.clients = clients;
	}

	public DTO() {
	}

	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
}
