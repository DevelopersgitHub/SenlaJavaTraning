package com.senla.store;

import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;

public interface IShop {
	void addClient(Client clients);
	void removeClient(Client c);
	void addOrder(Order o);
	void removeOrder(Order o);
	void addBook(Book o);
	void removeBook(Book o);
}
