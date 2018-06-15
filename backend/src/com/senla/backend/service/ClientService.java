package com.senla.backend.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.ClientFileUtil;
import com.senla.backend.fileutil.IClientFileUtil;
import com.senla.backend.model.Client;
import com.senla.backend.store.IClientStore;
import com.senla.di.DI;

public class ClientService implements IClientService{
	private static final Logger LOGGER = LogManager.getLogger(ClientService.class.getSimpleName());
	
	final IClientFileUtil<Client> util = new ClientFileUtil();

	private IClientStore clientStore;
	
	public ClientService() {
		clientStore = DI.configure(IClientStore.class);
	}
	
	public void addClient(Client client) {
		   clientStore.addClient(client);
	 }

	public void removeClient(Long id) {
		clientStore.removeClient(id);
	}

	public void updateClient(Long id, Client client) {
		clientStore.updateClient(id, client);
	}

	public Client getClient(Long id) {
		Client client = null;
		try {
			client = clientStore.getClient(clientStore.loadClient(), id);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return client;
	}

	public List<Client> getAllClient() {
		List<Client> client = null;
		try {
			client = clientStore.getAllClient();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return client;
	}

	public Client[] loadClient() {
		Client[] clients = null;
		try {
			clients = clientStore.loadClient();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return clients;
	}

	public void saveClient(Client[] clients) {
		clientStore.saveClient(clients);
		
	}

}
