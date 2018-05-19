package com.senla.backend.controller;

public class MainMVC {
	public static void main(String[] args) {
		
	IController controller = new Controller();
	
	/*
	 * get book lists, orders and clients
	 */
	
	controller.showBooks();
	controller.showOrders();
	controller.showClients();
	
	/*
	 * Sorting books and orders
	 */
	
	controller.showSortNameBook();
	controller.showSortDatePublicBook();
	controller.showSortCostBook();
	controller.showSortPresenceBook();
	
	
	controller.showSortDateExecutionOrder();
	controller.showSortCostOrder();
	controller.showSortStatusOrder();
	
	/*
	 * View order details and book description
	 */
	
	controller.showOrderDetails();
	controller.showBookDescription();
	
	/*
	 * List and count of completed orders for time trials
	 * (sorting by date and price)
	 */
	
	controller.showListCompletedOrders();
	controller.showCountCompletedOrders();
	
	controller.showSortListCompletedOrderByDate();
	controller.showSortListCompletedOrderByCost();
	
	/*
	 * Amount of funds earned
	 */
	controller.showSumOrders();
	
	/*
	 * The list of book requests is based on the query: 
	 * "get all orders that contain this book"
	 */
	
	controller.showCountRequestBooks();
	
	/*
	 * Sorting count request
	 */
	
	controller.showSortCountRequestBooks();
	controller.showSortAlphRequestBooks();

	
	/*
	 * The list of unsold books is determined
	 * by orders in which the order 
	 * status has been waiting for more than 6 months.
	 */
	
	controller.orderListStaleBook();
	}
}

