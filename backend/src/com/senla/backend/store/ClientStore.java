package com.senla.backend.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public void addClient(Client client) {
		clients.add(client);
		
	}
	
	public void updateClient(Long id, Client client) {
		for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getClientID().equals(id)) {
            	clients.set(i, client);
            }
        }
	}
	
	public Client getClient(Client[] client, Long id)  {
		List<Client> list = Arrays.asList(client); 
		return list.stream().filter(p -> p.getClientID().equals(id)).collect(Collectors.<Client> toList()).get(0); 
	}
	
	public List<Client> getAllClient() {
		return this.clients;
	}

	public void removeClient(Long id) {
		for(Client client : clients) {
			if(client.getClientID().equals(id)) {
				clients.remove(client);
				return;
			}
		}
	}

	public Client[] loadClient() {
		Client[] clients = null;
		try {
			clients = util.readFromFile();
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return clients;
	}

	public void saveClient(Client[] clients) {
		util.writeToFile(clients);
		
	}

}
