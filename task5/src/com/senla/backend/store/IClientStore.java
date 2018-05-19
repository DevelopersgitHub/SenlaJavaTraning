package com.senla.backend.store;

import java.util.List;

import com.senla.backend.model.Client;

public interface IClientStore {

	public void addClient(Client client);
	public boolean removeClient(Client client);
	public void update(List<Client> client);
	public Client getClient();
	public Client[] getAllClient();
	
}
