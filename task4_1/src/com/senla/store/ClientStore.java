package com.senla.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.ClientFileUtil;
import com.senla.fileutil.IClientFileUtil;
import com.senla.model.Client;

public class ClientStore implements IClientStore{
	
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
	
	public Client getClient() throws NumberFormatException, ParseException  {
		Client client = new Client();
		Client[] readedValues = util.readFromFile();
				for(int i=0;i<readedValues.length;i++) {
					client = readedValues[0];
				}
				return client;
	}
	
	public Client[] getAllClient() throws NumberFormatException, ParseException {
		Client[] readedValues = util.readFromFile();
		return readedValues;
	}

	public boolean removeClient(Client client) {
		 return clients.remove(client);
	}

}
