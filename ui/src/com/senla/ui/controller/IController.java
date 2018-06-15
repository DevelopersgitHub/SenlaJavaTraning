package com.senla.ui.controller;

public interface IController {
	public void addBook();
	public void getBook();
	public void getAllBook();
	public void updateBook();
	public void removeBook();
	
	public void addOrder();
	public void getOrder();
	public void getAllOrder();
	public void updateOrder();
	public void removeOrder();
	
	public void addClient();
	public void getClient();
	public void getAllClient();
	public void updateClient();
	public void removeClient();
	
	public void loadBook();
	public void loadOrder();
	public void loadClient();
	
	public void saveBook();
	public void saveOrder();
	public void saveClient();

	public void showBooks();
	public void showOrders();
	public void showClients();
	
	public void showSortNameBook();
	public void showSortDatePublicBook();
	public void showSortCostBook();
	public void showSortPresenceBook();
	public void showBookDescription();
	
	public void showSortDateExecutionOrder();
	public void showSortCostOrder();
	public void showSortStatusOrder();
	public void showOrderDetails();
	
	public void showListCompletedOrders();
	public void showCountCompletedOrders();
	public void showSortListCompletedOrderByDate();
	public void showSortListCompletedOrderByCost();
	
	public void showSumOrders();
	
	public void showCountRequestBooks();
	public void showSortCountRequestBooks();
	public void showSortAlphRequestBooks();
	
	public void orderListStaleBook();
	
	public void showCloneOrder();
	
	public void showImport();
	public void showExport();
	
	public void showSerialization();
	public void showDeserialization();
	
}
