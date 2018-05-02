package com.senla.controller;

import java.text.ParseException;
import java.util.Date;

import com.senla.model.Book;
import com.senla.model.Order;
import com.senla.service.IServiceBook;
import com.senla.service.IServiceClient;
import com.senla.service.IServiceOrder;
import com.senla.service.ServiceBook;
import com.senla.service.ServiceClient;
import com.senla.service.ServiceOrder;
import com.senla.model.Client;
import com.senla.store.BookStore;
import com.senla.store.ClientStore;
import com.senla.store.IBookStore;
import com.senla.store.IClientStore;
import com.senla.store.IOrderStore;
import com.senla.store.IShop;
import com.senla.store.OrderStore;
import com.senla.store.Shop;

public class Main {
	public static void main(String[] args) throws NumberFormatException, ParseException {
		
		/*
		 * add a customer, order and a book based on the current time
		 */
		
		Date date = new Date();
		
		IShop shop = new Shop();
		IServiceClient clientService = new ServiceClient();
		Client clientShop = new Client(1L,"Mick");
		Order orderShop = new Order(7L,"Alchemist", date, 446.23, "1");
		Book bookShop = new Book(4L, "Divergent", date,764.23,true,"description");
		shop.addClient(clientShop);
		shop.addOrder(orderShop);
		shop.addBook(bookShop);
		
		/*
		 * get book lists, orders and clients
		 */
		
		System.out.println("List of books\n---------------------\n");
		IBookStore book = new BookStore();
		Book[] books = book.getAllBook();
		for(int i = 0;i<books.length;i++) {
			System.out.println(books[i]);
		}
		
		System.out.println("\nList of orders\n---------------------\n");
		IOrderStore order = new OrderStore();
		Order[] orders = order.getAllOrder();
		for(int i = 0;i<orders.length;i++) {
			System.out.println(orders[i]);
		}

		System.out.println("\nList of clients\n---------------------\n");
		IClientStore client = new ClientStore();
		Client[] clients = client.getAllClient();
		for(int i = 0;i<clients.length;i++) {
			System.out.println(clients[i]);
		}
		
		/*
		 * sorting books and orders
		 */
		
		IServiceBook serviceBook = new ServiceBook();
		Book[] booksSort = book.getAllBook();
		booksSort = serviceBook.sortNameBook(books);
		System.out.println("\nSort by alphabetically: \n");
		System.out.println("---------------------");
		for (int i = 0; i < booksSort.length; i++ ){
			System.out.println(booksSort[i].getBookName());
		}
		
		booksSort = serviceBook.sortDatePublic(books);
		System.out.println("\nSort by publication date: \n");
		System.out.println("---------------------");
		for (int i = 0; i < booksSort.length; i++ ){
			System.out.println(booksSort[i].getBookName() + ", Data of publication: " + booksSort[i].getBookDatePublic());
		}
		
		booksSort = serviceBook.sortCost(books);
		System.out.println("\nSort by cost: \n");
		System.out.println("---------------------");
		for (int i = 0; i < booksSort.length; i++ ){
			System.out.println(booksSort[i].getBookName() + ", Cost: " + booksSort[i].getBookCost());
		}
		
		booksSort = serviceBook.sortPresense(books);
		System.out.println("\nSort by availability of books: \n");
		System.out.println("---------------------");
		for (int i = 0; i < booksSort.length; i++ ){
			System.out.println(booksSort[i].getBookName() + ", In stock: " + booksSort[i].getBookPresence());
		}
		
		IServiceOrder serviceOrder = new ServiceOrder();
		Order[] orderSort = order.getAllOrder();
		orderSort = serviceOrder.sortDateExecution(orderSort);
		System.out.println("\n\nSort by execution date: \n");
		System.out.println("---------------------");
		for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID()+  "\nDate: " + orderSort[i].getOrderExecutionDate());
		}	
		
		System.out.println("\nSorting by cost: \n");
		System.out.println("---------------------");
		orderSort = serviceOrder.sortCostOrder(orderSort);
		for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID() + "\nCost: " +  orderSort[i].getOrderCost());
		}	
		
		System.out.println("\nSort by status: \n");
		System.out.println("---------------------");
		orderSort = serviceOrder.sortStatus(orderSort);
		for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID() + "\nStatus: " + orderSort[i].getOrderStatus());
		}
		
		/*
		 * View order details and book description
		 */
		
		System.out.println("\nDetails of order: ");
		System.out.println("\n---------------------");
		Order ord = order.getOrder();
		serviceOrder.orderDetails(ord);
		
		System.out.println("\nView book description: ");
		System.out.println("\n---------------------");
		Book bk = serviceBook.getBook();
		serviceBook.bookDescription(bk);
		
		/*
		 * list and count of completed orders
		 */
		
		Order ord1 = order.getOrder();
		clientService.addOrder(ord1);
		
		System.out.println("\n---------------------\n");
		Order[] orderListCompleted = order.getAllOrder();
		serviceOrder.listCompletedOrder(orderListCompleted);
		
		Order[] orderCountCompleted = order.getAllOrder();
		int count = serviceOrder.countCompletedOrder(orderCountCompleted);
		System.out.println("\n---------------------\n");
		System.out.println("Count of completed orders: " + count);
		
		
		Order[] orderSum = order.getAllOrder();
		double sum = serviceOrder.sumOrder(orderSum);
		System.out.println("\n---------------------\n");
		System.out.println("Amount of funds earned: " + sum);
		
		/*
		 * The list of book requests is based on the query: 
		 * "get all orders that contain this book."
		 */
		
		System.out.println("\n\n---------------------\n");
	 	String str = "Alchemist";
	 	String str1 = "Great Gatsby";
		Order[] countRequestBooks = order.getAllOrder();
		Integer n1 = serviceOrder.countRequest(countRequestBooks, str);
		Integer n2 = serviceOrder.countRequest(countRequestBooks, str1);
		
		serviceOrder.sortCountRequest(n1, n2);
		
		System.out.println("\n---------------------\n");
		Order[] sortAlp = order.getAllOrder();
		serviceOrder.sortAlphabetically(sortAlp, str);
		serviceOrder.sortAlphabetically(sortAlp, str1);
	
		Order[] orderListCompleted1 = serviceOrder.sortDateExecution(orderListCompleted);
		System.out.println("\n\nSort by execution date: \n");
		System.out.println("---------------------");
		for (int i = 0; i < orderListCompleted1.length; i++ ){
			System.out.println("ID Order: " + orderListCompleted1[i].getID()+  "\nDate: " + orderListCompleted1[i].getOrderExecutionDate());
		}	
		
		System.out.println("\nSorting by cost: \n");
		System.out.println("---------------------");
		Order[] orderListCompleted2 = serviceOrder.sortCostOrder(orderListCompleted);
		for (int i = 0; i < orderListCompleted2.length; i++ ){
			System.out.println("ID Order: " + orderListCompleted2[i].getID() + "\nCost: " +  orderListCompleted2[i].getOrderCost());
		}	
		
		/*
		 * The list of unsold books is determined
		 * by orders in which the order 
		 * status has been waiting for more than 6 months.
		 */
		
		System.out.println("\nList of stale books: \n");
		System.out.println("---------------------");
		Order[] orderListStaleBook = order.getAllOrder();
		serviceOrder.listStaleOrder(orderListStaleBook);
		
		}
	}
