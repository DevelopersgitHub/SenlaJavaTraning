package com.senla.backend.controller;

public interface IController {
	public void showBooks();
	public void showOrders();
	public void showClients();
	public void showSortNameBook();
	public void showSortDatePublicBook();
	public void showSortCostBook();
	public void showSortPresenceBook();
	public void showSortDateExecutionOrder();
	public void showSortCostOrder();
	public void showSortStatusOrder();
	public void showOrderDetails();
	public void showBookDescription();
	public void showListCompletedOrders();
	public void showCountCompletedOrders();
	public void showSumOrders();
	public void showCountRequestBooks();
	public void showSortCountRequestBooks();
	public void showSortAlphRequestBooks();
	public void showSortListCompletedOrderByDate();
	public void showSortListCompletedOrderByCost();
	public void orderListStaleBook();
}
