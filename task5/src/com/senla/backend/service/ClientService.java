package com.senla.backend.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.ClientFileUtil;
import com.senla.backend.fileutil.IClientFileUtil;
import com.senla.backend.model.Client;
import com.senla.backend.store.BookStore;
import com.senla.backend.store.ClientStore;
import com.senla.backend.store.IBookStore;
import com.senla.backend.store.IClientStore;
import com.senla.backend.store.IOrderStore;
import com.senla.backend.store.OrderStore;

public class ClientService implements IClientService{
	private static final Logger LOGGER = LogManager.getLogger(ClientService.class.getSimpleName());
	
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

	public Client getClient() {
		Client client = null;
		try {
			client = clientStore.getClient();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		return client;
	}

	public Client[] getAllClient() {
		Client[] client = null;
		try {
			client = clientStore.getAllClient();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		return client;
	}
}
