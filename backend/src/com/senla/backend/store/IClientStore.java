package com.senla.backend.store;

import java.util.List;

import com.senla.backend.model.Client;

public interface IClientStore {

	public void addClient(Client client);
	public void removeClient(Long id);
	public void updateClient(Long id, Client client);
	public Client getClient(Client[] client, Long id);
	public List<Client> getAllClient();
	public Client[] loadClient();
	public void saveClient(Client[] clients);
	
}
