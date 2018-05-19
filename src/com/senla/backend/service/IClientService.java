package com.senla.backend.service;

import java.util.List;

import com.senla.backend.model.Client;

public interface IClientService {

	public void addClient(Client client);
	public boolean removeClient(Client client);
	public void update(List<Client> client);
	public Client getClient();
	public Client[] getAllClient();
}
