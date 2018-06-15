package com.senla.backend.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.annotation.ConfigAnnotation;
import com.senla.annotation.ConfigProperty;
import com.senla.backend.dto.DTO;
import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;
import com.senla.backend.service.IShop;
import com.senla.di.DI;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getSimpleName());
    
    @ConfigProperty(propertyName = "month", type = Integer.class)
   	private Integer count;
   	
   	@ConfigProperty(propertyName = "completedRequest", type = Boolean.class)
   	private Boolean powerOrders;
   	
	public Main() {
		ConfigAnnotation.loadAnnotation(this);
	}
	
	public static void main(String[] args) {
		
		IShop shop = DI.configure(IShop.class);
		
		//shop.countMonthWait(count);
		//shop.powerOrdersCompeled(powerOrders);
		
		System.out.println("\n\nSerializationUtil\n\n");
	
		DTO bookSerial = shop.deserialization();
		
		for(Book bookSer : bookSerial.getBooks()) {
			System.out.println(bookSer);
		}
		System.out.println("\n\n");
		for(Order bookSer : bookSerial.getOrders()) {
			System.out.println(bookSer);
		}
		System.out.println("\n\n");
		for(Client bookSer : bookSerial.getClients()) {
			System.out.println(bookSer);
		}
		
		shop.serialization();
		
		System.out.println("\nCSVUtil\n");
		
		shop.importCSV();
		List<Book> books = Arrays.asList(shop.loadBook());
		for(Book book : books) {
			System.out.println(book);
		}
		
		shop.exportCSV();
		
		System.out.println("\nThe data was successfully exported to a csv file\n");

		System.out.println("\nCloning\n\n");
		Order[] orders = shop.loadOrder();
		Order[] orderClone = null;
		orderClone = orders.clone();
		
		for(Order o : orderClone) {
			System.out.println(o.toString());
		}
	
		System.out.println("\nList of books\n-----\n");
		
		Book[] book = null;
		try {
			book = shop.loadBook();
			for(Book bookList : book) {
				System.out.println(bookList);
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
		System.out.println("\nList of orders\n-----\n");
		
		Order[] order = null;
		try {
			order = shop.loadOrder();
			for(Order orderList : order) {
				System.out.println(orderList);
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
		
		System.out.println("\nList of clients\n-----\n");
		
		Client[] client;
		try {
			client = shop.loadClient();
			for(Client clientList : client) {
				System.out.println(clientList);
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
		try {
			shop.addBook(new Book(4L, "Divergent", parseDate("22//08//2011","dd//MM//yyyy"), 644.23, true, "Divergent is the debut novel of American novelist Veronica Roth, published by HarperCollins Children's Books in 2011"));
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		try {
			shop.addOrder(new Order(1L,"Alchemist",parseDate("25//08//2018","dd//MM//yyyy"), 1231.27,"Completed"));
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		shop.addClient(new Client(1L,"Senla"));
		
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
		List<Order> listCompleted = null;
		listCompleted = shop.listCompletedOrder(order);
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
		double sumOrder;
		sumOrder = shop.sumOrder(order);
		System.out.printf("Amount: %8.2f  ", sumOrder);
		
		
		System.out.println("\n\nCount of completed orders for a period of time\n-----\n");
		int countCompletedOrders;
		try {
			countCompletedOrders = shop.countCompletedOrder(order);
			System.out.println(countCompletedOrders);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
		
		System.out.println("\nList of stale books\n-----\n");
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
		Order orderView;
		try {
			orderView = shop.getOrder(order, 1L);
			String stringOrder = shop.orderDetails(orderView , 1L);
			System.out.println(stringOrder);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
		System.out.println("\nView book description\n-----\n");
		try {
			String stringBook = shop.bookDescription(book, 1L);
			System.out.println(stringBook);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
}

	public static Date parseDate (String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
}
