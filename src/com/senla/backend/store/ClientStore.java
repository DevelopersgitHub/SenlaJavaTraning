package com.senla.backend.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.fileutil.ClientFileUtil;
import com.senla.backend.fileutil.IClientFileUtil;
import com.senla.backend.model.Client;

public class ClientStore implements IClientStore{
	private static final Logger LOGGER = LogManager.getLogger(ClientStore.class.getSimpleName());
	
	final IClientFileUtil<Client> util = new ClientFileUtil();
	
	private List<Client> clients;
	
	public ClientStore() {
		clients = new ArrayList<Client>();
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client client) {
		clients.add(client);
		
	}
	
	public void update(List<Client> client) {
		this.clients = client;
	}
	
	public Client getClient() {
		Client client = new Client();
		Client[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				client = readedValues[0];
			}
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (ParseException e) {
			LOGGER.error("ParseException" + e.getClass());
		}
		return client;
	}
	
	public Client[] getAllClient() {
		Client[] readedValues = null;
		try {
			readedValues = util.readFromFile();
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (ParseException e) {
			LOGGER.error("ParseException" + e.getClass());
		}
		return readedValues;
	}

	public boolean removeClient(Client client) {
		 return clients.remove(client);
	}

}
