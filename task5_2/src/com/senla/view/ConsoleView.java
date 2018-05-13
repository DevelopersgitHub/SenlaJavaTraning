package com.senla.view;

import java.util.ArrayList;

import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;

public class ConsoleView implements IView {
	public void showBooks(Book[] books) {
		System.out.println("\nList of books\n---------------------\n");
		for(int i = 0;i < books.length;i++) {
			System.out.println(books[i]);
		}
	}

	public void showOrders(Order[] orders) {
		System.out.println("\nList of orders\n---------------------\n");
		for(int i = 0;i < orders.length;i++) {
			System.out.println(orders[i]);
		}
		
	}

	public void showClients(Client[] clients) {
		System.out.println("\nList of clients\n---------------------\n");
		for(int i = 0;i < clients.length;i++) {
			System.out.println(clients[i]);
		}
	}
	
	public void showSortNameBook(Book[] booksSort) {
			System.out.println("\nSort by alphabetically\n---------------------\n");
			for (int i = 0; i < booksSort.length; i++ ){
				System.out.println(booksSort[i].getBookName());
			}
	}
	
	public void showSortDatePublicBook(Book[] booksSort) {
		System.out.println("\nSort by publication date\n---------------------\n");
			for (int i = 0; i < booksSort.length; i++ ){
				System.out.println(booksSort[i].getBookName() + ", Data of publication: " + booksSort[i].getBookDatePublic());
		}
	}
	
	public void showSortCostBook(Book[] booksSort) {
		System.out.println("\nSort by cost\n---------------------\n");
			for (int i = 0; i < booksSort.length; i++ ){
				System.out.println(booksSort[i].getBookName() + ", Cost: " + booksSort[i].getBookCost());
		}	
	}
	
	public void showSortPresenceBook(Book[] booksSort) {
		System.out.println("\nSort by availability of books\n---------------------\n");
			for (int i = 0; i < booksSort.length; i++ ){
				System.out.println(booksSort[i].getBookName() + ", In stock: " + booksSort[i].getBookPresence());
		}
	}

	public void showSortDateExecutionOrder(Order[] orderSort) {
		System.out.println("\n\nSort by execution date\n---------------------\n");
		for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID()+  "\nDate: " + orderSort[i].getOrderExecutionDate());
		}
	}

	public void showSortCostOrder(Order[] orderSort) {
		System.out.println("\nSorting by cost\n---------------------\n");
		for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID() + "\nCost: " +  orderSort[i].getOrderCost());
		}
	}

	public void showSortStatusOrder(Order[] orderSort) {
		System.out.println("\nSort by status\n---------------------\n");
		for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID() + "\nStatus: " + orderSort[i].getOrderStatus());
		}	
	}
	
	

	public void showOrderDetails(String s) {
		System.out.println("\nOrder details\n---------------------\n");
		System.out.println(s);
	}
	public void showBookDescription(String s) {
		System.out.println("\nBook description\n---------------------\n");
		System.out.println(s);
	}

	public void showListCompletedOrders(ArrayList<Order> s) {
		System.out.println("\nList of completed orders\n---------------------\n");
		for(Order l : s) {
			System.out.println(l);
		}
	}

	public void showCountCompletedOrders(int count) {
		System.out.println("\nCount of completed orders: " + count);
		System.out.println("\n---------------------\n");
	}
	
	public void showSortListCompletedOrderByDate(ArrayList<Order> s) {
		System.out.println("Sort by execution date\n---------------------\n");
		for (Object o : s){
			System.out.println(o);
		}
	}
	public void showSortListCompletedOrderByCost(ArrayList<Order> s) {
		System.out.println("\n---------------------\n");
		System.out.println("Sort by cost\n---------------------\n");
		for (Object o : s){
			System.out.println(o);
		}
	}
	
	public void showSumOrders(double sum) {
		System.out.println("\n---------------------\n");
		System.out.println("Amount of funds earned: " + sum);
		System.out.println("\n---------------------\n");
	}
	
	public void showCountRequestBooks(Integer n1, Integer n2) {
		System.out.println("Count of requests for 'Alchemist': " + n1 +  "\n" +
							"Count of requests for 'Great Gatsby': " + n2 + "\n---------------------\n");
	}

	public void showSortCountRequestBooks(ArrayList<Integer> array) {
		System.out.println("Sorting by count\n");
		for(Object o : array) {
			System.out.println(o);
		}
	}
	
	public void showSortAlphRequestBooks(ArrayList<Order> array) {
		System.out.println("\n---------------------\n");
		System.out.println("Sorting by alphabet\n");
		for(Object o : array) {
			System.out.println(o);
		}
	}
	
	public void orderListStaleBook(ArrayList<Order> list) {
		System.out.println("\nList of stale books\n---------------------\n");
		for(Order array : list) {
			System.out.println("ID orders: " + array.getID() + " Book: " + array.getOrderContent() + ", Data of execution orders: "+ array.getOrderExecutionDate() + ", Cost of orders: " + array.getOrderCost());
		}
	}
}

