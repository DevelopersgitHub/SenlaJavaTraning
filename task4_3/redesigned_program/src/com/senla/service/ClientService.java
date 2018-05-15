package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.fileutil.ClientFileUtil;
import com.senla.fileutil.IClientFileUtil;
import com.senla.model.Client;
import com.senla.store.BookStore;
import com.senla.store.ClientStore;
import com.senla.store.IBookStore;
import com.senla.store.IClientStore;
import com.senla.store.IOrderStore;
import com.senla.store.OrderStore;

public class ClientService implements IClientService{
	
	final IClientFileUtil<Client> util = new ClientFileUtil();

	private IBookStore bookStore = new BookStore();
	private IOrderStore orderStore = new OrderStore();
	private IClientStore clientStore = new ClientStore();
	
	public ClientService() {
		
	}

	public IBookStore getBookStore() {
		return bookStore;
	}

	public void setBookStore(IBookStore bookStore) {
		this.bookStore = bookStore;
	}

	public IOrderStore getOrderStore() {
		return orderStore;
	}

	public void setOrderStore(IOrderStore orderStore) {
		this.orderStore = orderStore;
	}

	public IClientStore getClientStore() {
		return clientStore;
	}

	public void setClientStore(IClientStore clientStore) {
		this.clientStore = clientStore;
	}

	public void addClient(Client client) {
		   clientStore.addClient(client);
	 }

	public boolean removeClient(Client client) {
		return clientStore.removeClient(client);
	}

	public void update(List<Client> client) {
		clientStore.update(client);
		
	}

	public Client getClient() throws NumberFormatException, ParseException {
		Client client = clientStore.getClient();
		return client;
	}

	public Client[] getAllClient() throws NumberFormatException, ParseException {
		Client[] client = clientStore.getAllClient();
		return client;
	}
}
