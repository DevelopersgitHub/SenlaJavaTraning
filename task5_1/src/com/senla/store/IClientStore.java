package com.senla.store;


import com.senla.model.Client;

public interface IClientStore {
	public void addClient(Client c);
	public void removeClient(Client c);
	public Client getClient(); 
	public Client[] getAllClient();
}
