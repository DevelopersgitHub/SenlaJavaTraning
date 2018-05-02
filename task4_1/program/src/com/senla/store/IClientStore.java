package com.senla.store;

import java.text.ParseException;

import com.senla.model.Client;

public interface IClientStore {
	public void addClient(Client c);
	public void removeClient(Client c);
	public Client getClient() throws NumberFormatException, ParseException; 
	public Client[] getAllClient() throws NumberFormatException, ParseException;
}
