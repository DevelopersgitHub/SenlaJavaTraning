package com.senla.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;
import com.senla.service.IShop;
import com.senla.service.Shop;

public class Main {
	public static void main(String[] args) throws NumberFormatException, ParseException {

		IShop shop = new Shop();
		shop.addBook(new Book(4L, "Divergent", parseDate("22//08//2011","dd//MM//yyyy"), 644.23, true, "Divergent is the debut novel of American novelist Veronica Roth, published by HarperCollins Children's Books in 2011"));
		shop.addOrder(new Order(1L,"Alchemist",parseDate("25//08//2018","dd//MM//yyyy"), 1231.27,"Completed"));
		shop.addClient(new Client(1L,"Senla"));
		
		System.out.println("\nList of books\n-----\n");
		
		Book[] book = shop.getAllBook();
		for(Book bookList : book) {
			System.out.println(bookList);
		}
		
		System.out.println("\nList of orders\n-----\n");
		
		Order[] order = shop.getAllOrder();
		for(Order orderList : order) {
			System.out.println(orderList);
		}
		
		
		System.out.println("\nList of clients\n-----\n");
		
		Client[] client = shop.getAllClient();
		for(Client clientList : client) {
			System.out.println(clientList);
		}
		
		
		System.out.println("\nSorting of books by name\n-----\n");
		
		book = shop.sortNameBook(book);
		for(Book bookSort : book) {
			System.out.println(bookSort.getBookName());
		}
		
		System.out.println("\nSorting of books by date public\n-----\n");
		
		book = shop.sortDatePublic(book);
		for(Book bookSort : book) {
			System.out.println(bookSort.getBookName() + ": " + bookSort.getBookDatePublic());
		}
		
		System.out.println("\nSorting of books by cost\n-----\n");
		
		book = shop.sortCost(book);
		for(Book bookSort : book) {
			System.out.println(bookSort.getBookName() + ": " + bookSort.getBookCost());
		}
		
		System.out.println("\nSorting of books by presence\n-----\n");
		
		book = shop.sortPresense(book);
		for(Book bookSort : book) {
			System.out.println(bookSort.getBookName() + ": " + bookSort.getBookPresence());
		}
	
		System.out.println("\nSorting of orders by date execution\n-----\n");
		
		order = shop.sortDateExecution(order);
		for(Order ordersSort : order) {
			System.out.println("Order ID: " + ordersSort.getID() + ": " + ordersSort.getOrderExecutionDate());
		}
		
		System.out.println("\nSorting of orders by cost\n-----\n");
		
		order = shop.sortCostOrder(order);
		for(Order ordersSort : order) {
			System.out.println("Order ID: " + ordersSort.getID() + ": " + ordersSort.getOrderCost());
		}
		
		System.out.println("\nSorting of orders by status\n-----\n");
		
		order = shop.sortStatus(order);
		for(Order ordersSort : order) {
			System.out.println("Order ID: " + ordersSort.getID() + ": " + ordersSort.getOrderStatus());
		}
		
		System.out.println("\nCount of book requests\n-----\n");

		String str = "Alchemist";
		int count = shop.countRequest(order, str);
		System.out.println("Alchemist: " + count);
		
		String str1 = "Great Gatsby";
		int count1 = shop.countRequest(order, str1);
		System.out.println("Great Gatsby: " + count1);
		
		System.out.println("\nSorting of book requests by count\n-----\n");
		
		List<Integer> n = shop.sortCountRequest(count, count1);
		for(Integer ordersSort : n) {
			System.out.println(ordersSort);
		}
		
		System.out.println("\nSorting of book requests by alph\n-----\n");
		List<Order> list = shop.methodAlphabeticallyForSort(order, str,str1);
		list = shop.sortAlphabetically(list);
		for(Order ordersSort : list) {
			System.out.println(ordersSort);
		}
		
		System.out.println("\nList of completed orders for a period of time\n-----\n");
		List<Order> listCompleted = shop.listCompletedOrder(order);
		for(Order ordersCompleted : listCompleted) {
			System.out.println(ordersCompleted);
		}
		
		System.out.println("\nSorting by the date of the list of completed orders for a period of time\n-----\n");
		listCompleted = shop.sortListCompletedOrderByDate(listCompleted);
		for(Order ordersCompletedSort : listCompleted) {
			System.out.println(ordersCompletedSort);
		}
		
		System.out.println("\nSorting by the cost of the list of completed orders for a period of time\n-----\n");
		listCompleted = shop.sortListCompletedOrderByCost(listCompleted);
		for(Order ordersCompletedSort : listCompleted) {
			System.out.println(ordersCompletedSort);
		}
		
		
		System.out.println("\nAmount of funds earned over a period of time\n-----");
		double sumOrder = shop.sumOrder(order);
		System.out.printf("Amount: %8.2f  ", sumOrder);
		
		
		System.out.println("\n\nCount of completed orders for a period of time\n-----\n");
		int countCompletedOrders = shop.countCompletedOrder(order);
		System.out.println(countCompletedOrders);
		
		
		System.out.println("\nlist of stale books\n-----\n");
		list = shop.listStaleOrder(order);
		for(Order ordersSort : list) {
			System.out.println(ordersSort);
		}
		
		System.out.println("\nSort by the date of unsold books.\n-----\n");
		
		list = shop.sortListUnsoldBookByDate(list);
		for(Order ordersSort : list) {
			System.out.println(ordersSort);
		}
		
		System.out.println("\nSort by the cost of unsold books.\n-----\n");
		
		list = shop.sortListUnsoldBookByCost(list);
		for(Order ordersSort : list) {
			System.out.println(ordersSort);
		}
		
		System.out.println("\nView order details\n-----\n");
		Order orderView = shop.getOrder();
		String stringOrder = shop.orderDetails(orderView , 1L);
		System.out.println(stringOrder);
		
		System.out.println("\nView book description\n-----\n");
		Book bookView= shop.getBook();
		String stringBook = shop.bookDescription(bookView, 1L);
		System.out.println(stringBook);
}
	
	public static Date parseDate (String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
}
