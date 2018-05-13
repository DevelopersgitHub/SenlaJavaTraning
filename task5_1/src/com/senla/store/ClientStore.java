package com.senla.store;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.fileutil.ClientFileUtil;
import com.senla.logger.MyLogger;
import com.senla.model.Client;

public class ClientStore implements IClientStore{

	final ClientFileUtil util = new ClientFileUtil();
	List<Client> clients = new ArrayList<Client>();
	
	public void addClient(Client c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		clients.add(c);
	}

	public void removeClient(Client c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		clients.remove(c);
	}
	
	public Client[] getAllClient() {
		Client[] readedValues = null;
		
			try {
				readedValues = util.readFromFile();
			} catch (NumberFormatException e) {
				MyLogger.logger.info("NumberFormatException: " + e.getClass());
			} catch (ParseException e) {
				MyLogger.logger.info("ParseException: " + e.getClass());
			} catch (IOException e) {
				MyLogger.logger.info("IOException: " + e.getClass());
			}
		return readedValues;
	}
	public Client getClient() {
		Client cln = new Client();
		Client[] readedValues;
			try {
				readedValues = util.readFromFile();
				for(int i=0;i<readedValues.length;i++) {
					cln = readedValues[0];
				}
			} catch (NumberFormatException e) {
				MyLogger.logger.info("NumberFormatException: " + e.getClass());
			} catch (ParseException e) {
				MyLogger.logger.info("ParseException: " + e.getClass());
			} catch (IOException e) {
				MyLogger.logger.info("IOException: " + e.getClass());
			}
		return cln;
	}
	public void saveClient(Client[] persons) {
			try{
				util.writeToFile(persons);
				throw new IOException();
			} catch (IOException e) {
				MyLogger.logger.info("IOException: " + e.getClass());
			}
		
	}
}
