package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Client;

public interface IClientService {

	public void addClient(Client client);
	public void removeClient(Long id);
	public void updateClient(Long id, Client client) ;
	public Client getClient(Long id);
	public List<Client> getAllClient();
	public Client[] loadClient();
	public void saveClient(Client[] clients);
}
