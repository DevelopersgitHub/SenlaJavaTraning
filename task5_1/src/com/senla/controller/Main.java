package com.senla.controller;

import java.util.Date;

import com.senla.logger.ILogger;
import com.senla.logger.MyLogger;
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
	public static void main(String[] args) {
		
		ILogger log = new MyLogger();
		log.defaultSeetings();
		
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
		
		try {
			Book[] books = book.getAllBook();
			for(int i = 0;i<books.length;i++) {
				System.out.println(books[i]);
			}
		}catch(Exception e) {
			MyLogger.logger.info("Error reading from the book list file");
		} finally {
			MyLogger.logger.info("Reading from the book list file");
		}
		
		
		System.out.println("\nList of orders\n---------------------\n");
		IOrderStore order = new OrderStore();
		try{
			Order[] orders = order.getAllOrder();
			for(int i = 0;i<orders.length;i++) {
			System.out.println(orders[i]);
		}
		}catch(Exception e) {
			MyLogger.logger.info("Error reading from the order list file");
		}finally {
			MyLogger.logger.info("Reading from the order list file");
		}

		System.out.println("\nList of clients\n---------------------\n");
			try{
				IClientStore client = new ClientStore();
				Client[] clients = client.getAllClient();
				for(int i = 0;i<clients.length;i++) {
					System.out.println(clients[i]);
				}
			}catch(Exception e) {
				MyLogger.logger.info("Error reading from the client list file");
			}finally {
				MyLogger.logger.info("Reading from the client list file");
			}
			
			
		/*
		 * sorting books and orders
		 */
		IServiceBook serviceBook = new ServiceBook();
		Book[] booksSort = book.getAllBook();
		try{
			booksSort = serviceBook.sortNameBook(booksSort);
			System.out.println("\nSort by alphabetically: \n");
			System.out.println("---------------------");
			for (int i = 0; i < booksSort.length; i++ ){
				System.out.println(booksSort[i].getBookName());
			}
		}finally {
			MyLogger.logger.info("Sorting books alphabetically");
		}
		
		booksSort = serviceBook.sortDatePublic(booksSort);
		System.out.println("\nSort by publication date: \n");
		System.out.println("---------------------");
		try{
			for (int i = 0; i < booksSort.length; i++ ){
			System.out.println(booksSort[i].getBookName() + ", Data of publication: " + booksSort[i].getBookDatePublic());
		}
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting books publication date");
		}finally {
			MyLogger.logger.info("Sorting books publication date");
		}
		
		booksSort = serviceBook.sortCost(booksSort);
		System.out.println("\nSort by cost: \n");
		System.out.println("---------------------");
		try{
			for (int i = 0; i < booksSort.length; i++ ){
			System.out.println(booksSort[i].getBookName() + ", Cost: " + booksSort[i].getBookCost());
		}
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting books cost");
		}finally {
			MyLogger.logger.info("Sorting books cost");
		}
		
		booksSort = serviceBook.sortPresense(booksSort);
		System.out.println("\nSort by availability of books: \n");
		System.out.println("---------------------");
		try{
			for (int i = 0; i < booksSort.length; i++ ){
		
			System.out.println(booksSort[i].getBookName() + ", In stock: " + booksSort[i].getBookPresence());
		}
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting books availability");
		}finally {
			MyLogger.logger.info("Sorting books availability");
		}
		
		IServiceOrder serviceOrder = new ServiceOrder();
		Order[] orderSort = order.getAllOrder();
		orderSort = serviceOrder.sortDateExecution(orderSort);
		System.out.println("\n\nSort by execution date: \n");
		System.out.println("---------------------");
		try{
			for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID()+  "\nDate: " + orderSort[i].getOrderExecutionDate());
		}	
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting books availability");
		}finally {
			MyLogger.logger.info("Sorting books availability");
		}
		
		System.out.println("\nSorting by cost: \n");
		System.out.println("---------------------");
		orderSort = serviceOrder.sortCostOrder(orderSort);
		try{
			for (int i = 0; i < orderSort.length; i++ ){
			System.out.println("ID Order: " + orderSort[i].getID() + "\nCost: " +  orderSort[i].getOrderCost());
		}	
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting books availability");
		}finally {
			MyLogger.logger.info("Sorting books availability");
		}
		
		System.out.println("\nSort by status: \n");
		System.out.println("---------------------");
		try{
			orderSort = serviceOrder.sortStatus(orderSort);
			for (int i = 0; i < orderSort.length; i++ ){
				System.out.println("ID Order: " + orderSort[i].getID() + "\nStatus: " + orderSort[i].getOrderStatus());
		}
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting orders status");
		}finally {
			MyLogger.logger.info("Sorting orders status");
		}
		
		/*
		 * View order details and book description
		 */
		
		System.out.println("\nDetails of order: ");
		System.out.println("\n---------------------");
		try{
			Order ord = order.getOrder();
			serviceOrder.orderDetails(ord);
		}catch(Exception e) {
			MyLogger.logger.info("Error view order details");
		}finally {
			MyLogger.logger.info("View order details");
		}
		
		System.out.println("\nView book description: ");
		System.out.println("\n---------------------");
		try{
			Book bk = serviceBook.getBook();
			serviceBook.bookDescription(bk);
		}catch(Exception e) {
			MyLogger.logger.info("Error view book description");
		}finally {
			MyLogger.logger.info("View book description");
		}
		/*
		 * list and count of completed orders
		 */
		
		Order ord1 = order.getOrder();
		clientService.addOrder(ord1);
		
		Order[] orderListCompleted = order.getAllOrder();
		System.out.println("\n---------------------\n");
		try{
			serviceOrder.listCompletedOrder(orderListCompleted);
		}catch(Exception e) {
			MyLogger.logger.info("Error list completed orders");
		}finally {
			MyLogger.logger.info("List completed orders");
		}
		
		Order[] orderCountCompleted = order.getAllOrder();
		try{
			int count = serviceOrder.countCompletedOrder(orderCountCompleted);
			System.out.println("\n---------------------\n");
			System.out.println("Count of completed orders: " + count);
		}catch(Exception e) {
			MyLogger.logger.info("Error count of completed orders");
		}finally {
			MyLogger.logger.info("Count of completed orders");
		}
		
		
		try{
			Order[] orderSum = order.getAllOrder();
			double sum = serviceOrder.sumOrder(orderSum);
			System.out.println("\n---------------------\n");
			System.out.println("Amount of funds earned: " + sum);
		}catch(Exception e) {
			MyLogger.logger.info("Error summ orders");
		}finally {
			MyLogger.logger.info("Summ orders");
		}
		/*
		 * The list of book requests is based on the query: 
		 * "get all orders that contain this book."
		 */
		
		System.out.println("\n\n---------------------\n");
	 	String str = "Alchemist";
	 	String str1 = "Great Gatsby";
		try{
			Order[] countRequestBooks = order.getAllOrder();
			Integer n1 = serviceOrder.countRequest(countRequestBooks, str);
			Integer n2 = serviceOrder.countRequest(countRequestBooks, str1);
			serviceOrder.sortCountRequest(n1, n2);
		}catch(Exception e) {
			MyLogger.logger.info("Error count of request");
		}finally {
			MyLogger.logger.info("Count of request");
		}
			
		System.out.println("\n---------------------\n");
		try{
			Order[] sortAlp = order.getAllOrder();
			serviceOrder.sortAlphabetically(sortAlp, str);
			serviceOrder.sortAlphabetically(sortAlp, str1);
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting orders by alphabetically");
		}finally {
			MyLogger.logger.info("Sorting orders by alphabetically");
		}
	
		Order[] orderListCompleted1 = serviceOrder.sortDateExecution(orderListCompleted);
		System.out.println("\n\nSort by execution date: \n");
		System.out.println("---------------------");
		try{
			for (int i = 0; i < orderListCompleted1.length; i++ ){
			System.out.println("ID Order: " + orderListCompleted1[i].getID()+  "\nDate: " + orderListCompleted1[i].getOrderExecutionDate());
		}	
		}catch(Exception e) {
			MyLogger.logger.info("Error sort by execution date");
		}finally {
			MyLogger.logger.info("Sort by execution date");
		}
		
		try{
			System.out.println("\nSorting by cost: \n");
			System.out.println("---------------------");
			Order[] orderListCompleted2 = serviceOrder.sortCostOrder(orderListCompleted);
			for (int i = 0; i < orderListCompleted2.length; i++ ){
				System.out.println("ID Order: " + orderListCompleted2[i].getID() + "\nCost: " +  orderListCompleted2[i].getOrderCost());
			}	
		}catch(Exception e) {
			MyLogger.logger.info("Error sorting orders cost");
		}finally {
			MyLogger.logger.info("Sorting orders cost");
		}
		
		/*
		 * The list of unsold books is determined
		 * by orders in which the order 
		 * status has been waiting for more than 6 months.
		 */
		
		try{
			System.out.println("\nList of stale books: \n");
			System.out.println("---------------------");
			Order[] orderListStaleBook = order.getAllOrder();
			serviceOrder.listStaleOrder(orderListStaleBook);
		}catch(Exception e) {
			MyLogger.logger.info("Error list of stale books");
		}finally {
			MyLogger.logger.info("List of stale books");
		}
	}
}
