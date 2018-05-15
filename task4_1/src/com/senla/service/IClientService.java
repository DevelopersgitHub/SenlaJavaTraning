package com.senla.service;

import java.text.ParseException;
import java.util.List;

import com.senla.model.Client;

public interface IClientService {

	public void addClient(Client client);
	public boolean removeClient(Client client);
	public void update(List<Client> client);
	public Client getClient() throws NumberFormatException, ParseException;
	public Client[] getAllClient() throws NumberFormatException, ParseException;
}
