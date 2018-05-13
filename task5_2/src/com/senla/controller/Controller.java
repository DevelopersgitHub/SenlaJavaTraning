package com.senla.controller;

import java.text.ParseException;
import java.util.ArrayList;

import com.senla.logger.MyLogger;
import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;
import com.senla.service.IServiceBook;
import com.senla.service.IServiceOrder;
import com.senla.service.ServiceBook;
import com.senla.service.ServiceOrder;
import com.senla.store.BookStore;
import com.senla.store.ClientStore;
import com.senla.store.IBookStore;
import com.senla.store.IClientStore;
import com.senla.store.IOrderStore;
import com.senla.store.OrderStore;
import com.senla.view.ConsoleView;
import com.senla.view.IView;

public class Controller implements IController {
	IBookStore bookStore = new BookStore();
	IView view = new ConsoleView();
	public void showBooks() {
		Book[] books;
		try {
			books = bookStore.getAllBook();
			view.showBooks(books);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}

	IOrderStore orderStore = new OrderStore();
	public void showOrders() {
		Order[] orders;
		try {
			orders = orderStore.getAllOrder();
			view.showOrders(orders);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}
	
	IClientStore clientStore = new ClientStore();
	public void showClients()  {
		Client[] clients;
		try {
			clients = clientStore.getAllClient();
			view.showClients(clients);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	};
	
	IServiceBook serviceBook = new ServiceBook();
	public void showSortNameBook()  {
		Book[] booksSort;
		try {
			booksSort = bookStore.getAllBook();
			booksSort = serviceBook.sortNameBook(booksSort);
			view.showSortNameBook(booksSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		} catch (SecurityException e) {
			MyLogger.logger.info("SecurityException: " + e.getClass());
		}
	}
	public void showSortDatePublicBook() {
		Book[] booksSort;
		try {
			booksSort = bookStore.getAllBook();
			booksSort = serviceBook.sortDatePublic(booksSort);
			view.showSortDatePublicBook(booksSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}

	public void showSortCostBook() {
		Book[] booksSort;
		try {
			booksSort = bookStore.getAllBook();
			booksSort = serviceBook.sortCost(booksSort);
			view.showSortCostBook(booksSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	public void showSortPresenceBook() {
		Book[] booksSort;
		try {
			booksSort = bookStore.getAllBook();
			booksSort = serviceBook.sortPresense(booksSort);
			view.showSortPresenceBook(booksSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	
	IServiceOrder serviceOrder = new ServiceOrder();
	
	public void showSortDateExecutionOrder() {
		Order[] orderSort;
		try {
			orderSort = orderStore.getAllOrder();
			orderSort = serviceOrder.sortDateExecution(orderSort);
			view.showSortDateExecutionOrder(orderSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	public void showSortCostOrder() {
		Order[] orderSort;
		try {
			orderSort = orderStore.getAllOrder();
			orderSort = serviceOrder.sortCostOrder(orderSort);
			view.showSortCostOrder(orderSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}
	public void showSortStatusOrder() {
		Order[] orderSort;
		try {
			orderSort = orderStore.getAllOrder();
			orderSort = serviceOrder.sortStatus(orderSort);
			view.showSortStatusOrder(orderSort);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}
		
	public void showOrderDetails() {
		Order ord;
		try {
			ord = orderStore.getOrder();
			String s = serviceOrder.orderDetails(ord,1L);
			view.showOrderDetails(s);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}
	public void showBookDescription() {
		Book book;
		try {
			book = bookStore.getBook();
			String s = serviceBook.bookDescription(book,1L);
			view.showBookDescription(s);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	public void showListCompletedOrders() {
		
		try {
			Order[] orderListCompleted = orderStore.getAllOrder();
			ArrayList<Order> s = serviceOrder.listCompletedOrder(orderListCompleted);
			view.showListCompletedOrders(s);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}
	
	public void showCountCompletedOrders() {
		try {
			Order[] orderCountCompleted = orderStore.getAllOrder();
			int count = serviceOrder.countCompletedOrder(orderCountCompleted);
			view.showCountCompletedOrders(count);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	
	public void showSortListCompletedOrderByDate() {
		
		Order[] orderListCompleted;
		try {
			orderListCompleted = orderStore.getAllOrder();
			ArrayList<Order> s = serviceOrder.listCompletedOrder(orderListCompleted);
			s = serviceOrder.sortListCompletedOrderByDate(s);
			view.showSortListCompletedOrderByDate(s);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	
	public void showSortListCompletedOrderByCost() {
		Order[] orderListCompleted;
		try {
			orderListCompleted = orderStore.getAllOrder();
			ArrayList<Order> s = serviceOrder.listCompletedOrder(orderListCompleted);
			s = serviceOrder.sortListCompletedOrderByCost(s);
			view.showSortListCompletedOrderByCost(s);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	public void showSumOrders() {
		Order[] orderSum;
		try {
			orderSum = orderStore.getAllOrder();
			double sum = serviceOrder.sumOrder(orderSum);
			view.showSumOrders(sum);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	public void showCountRequestBooks() {
		String str = "Alchemist";
	 	String str1 = "Great Gatsby";
	 	Order[] countRequestBooks;
		try {
			countRequestBooks = orderStore.getAllOrder();
			Integer n1 = serviceOrder.countRequest(countRequestBooks, str);
			Integer n2 = serviceOrder.countRequest(countRequestBooks, str1);
			view.showCountRequestBooks(n1,n2);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	
	public void showSortCountRequestBooks() {
		String str = "Alchemist";
	 	String str1 = "Great Gatsby";
	 	Order[] countRequestBooks;
		try {
			countRequestBooks = orderStore.getAllOrder();
			Integer n1 = serviceOrder.countRequest(countRequestBooks, str);
			Integer n2 = serviceOrder.countRequest(countRequestBooks, str1);
			ArrayList<Integer> array = serviceOrder.sortCountRequest(n1, n2);
			view.showSortCountRequestBooks(array);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	
	
	public void showSortAlphRequestBooks() {
		String str = "Alchemist";
	 	String str1 = "Great Gatsby";
	 	Order[] sortAlp;
		try {
			sortAlp = orderStore.getAllOrder();
			ArrayList<Order> array = serviceOrder.methodAlphabeticallyForSort(sortAlp, str,str1);
			array = serviceOrder.sortAlphabetically(array);
			view.showSortAlphRequestBooks(array);
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		
	}
	
	
	
	
	public void orderListStaleBook() {
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			Order[] orderListStaleBook = orderStore.getAllOrder();
			list = serviceOrder.listStaleOrder(orderListStaleBook);
			view.orderListStaleBook(list);
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
	}
	
	
	
}
