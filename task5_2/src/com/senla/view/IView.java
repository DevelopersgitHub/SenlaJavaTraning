package com.senla.view;


import java.util.ArrayList;

import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;

public interface IView {
	public void showBooks(Book[] books);
	public void showOrders(Order[] orders);
	public void showClients(Client[] clients);
	public void showSortNameBook(Book[] booksSort);
	public void showSortDatePublicBook(Book[] booksSort);
	public void showSortCostBook(Book[] booksSort);
	public void showSortPresenceBook(Book[] booksSort);
	public void showSortDateExecutionOrder(Order[] orderSort);
	public void showSortCostOrder(Order[] orderSort);
	public void showSortStatusOrder(Order[] orderSort);
	public void showOrderDetails(String s);
	public void showBookDescription(String s);
	public void showListCompletedOrders(ArrayList<Order> s);
	public void showCountCompletedOrders(int count);
	public void showSumOrders(double sum);
	public void showCountRequestBooks(Integer n1, Integer n2);
	public void showSortCountRequestBooks(ArrayList<Integer> array);
	public void showSortListCompletedOrderByDate(ArrayList<Order> s);
	public void showSortListCompletedOrderByCost(ArrayList<Order> s);
	public void orderListStaleBook(ArrayList<Order> list);
	public void showSortAlphRequestBooks(ArrayList<Order> array);
}
