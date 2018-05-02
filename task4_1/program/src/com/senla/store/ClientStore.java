package com.senla.store;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.ClientFileUtil;
import com.senla.model.Client;

public class ClientStore implements IClientStore{

	final ClientFileUtil util = new ClientFileUtil();
	List<Client> clients = new ArrayList<Client>();
	
	public void addClient(Client c) {
		clients.add(c);
	}

	public void removeClient(Client c) {
		clients.remove(c);
	}
	
	public Client[] getAllClient() throws NumberFormatException, ParseException {
		final Client[] readedValues = util.readFromFile();
		return readedValues;
	}
	public Client getClient() throws NumberFormatException, ParseException {
		Client cln = new Client();
		final Client[] readedValues = util.readFromFile();
		for(int i=0;i<readedValues.length;i++) {
			cln = readedValues[0];
		}
		return cln;
	}
	public void saveClient(Client[] persons) throws NumberFormatException, ParseException {
		util.writeToFile(persons);
	}
}
