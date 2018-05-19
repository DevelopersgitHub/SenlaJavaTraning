package com.senla.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;
import com.senla.backend.service.IShop;
import com.senla.backend.service.Shop;
import com.senla.backend.view.ConsoleView;
import com.senla.backend.view.IView;

public class Controller implements IController {
	private static final Logger LOGGER = LogManager.getLogger(Controller.class.getSimpleName());
	
	IShop shop = new Shop();
	IView view = new ConsoleView();
	
	public void showBooks() {
		Book[] books;
		try {
			books = shop.getAllBook();
			view.showBooks(books);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException: " + e.getClass());
		}
	}

	public void showOrders() {
		Order[] orders;
		try {
			orders = shop.getAllOrder();
			view.showOrders(orders);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException: " + e.getClass());
		}
	}
	public void showClients()  {
		Client[] clients;
		try {
			clients = shop.getAllClient();
			view.showClients(clients);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	};

	public void showSortNameBook()  {
		Book[] booksSort;
		try {
			booksSort = shop.getAllBook();
			booksSort = shop.sortNameBook(booksSort);
			view.showSortNameBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		} catch (SecurityException e) {
			LOGGER.error("SecurityException" + e.getClass());
		}
	}
	public void showSortDatePublicBook() {
		Book[] booksSort;
		try {
			booksSort = shop.getAllBook();
			booksSort = shop.sortDatePublic(booksSort);
			view.showSortDatePublicBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
	}

	public void showSortCostBook() {
		Book[] booksSort;
		try {
			booksSort = shop.getAllBook();
			booksSort = shop.sortCost(booksSort);
			view.showSortCostBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	public void showSortPresenceBook() {
		Book[] booksSort;
		try {
			booksSort = shop.getAllBook();
			booksSort = shop.sortPresense(booksSort);
			view.showSortPresenceBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	
	public void showSortDateExecutionOrder() {
		Order[] orderSort;
		try {
			orderSort = shop.getAllOrder();
			orderSort = shop.sortDateExecution(orderSort);
			view.showSortDateExecutionOrder(orderSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	public void showSortCostOrder() {
		Order[] orderSort;
		try {
			orderSort = shop.getAllOrder();
			orderSort = shop.sortCostOrder(orderSort);
			view.showSortCostOrder(orderSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
	}
	public void showSortStatusOrder() {
		Order[] orderSort;
		try {
			orderSort = shop.getAllOrder();
			orderSort = shop.sortStatus(orderSort);
			view.showSortStatusOrder(orderSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
	}
		
	public void showOrderDetails() {
		Order ord;
		try {
			ord = shop.getOrder();
			String s = shop.orderDetails(ord,1L);
			view.showOrderDetails(s);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
	}
	public void showBookDescription() {
		Book book;
		try {
			book = shop.getBook();
			String s = shop.bookDescription(book,1L);
			view.showBookDescription(s);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	public void showListCompletedOrders() {
		
		try {
			Order[] orderListCompleted = shop.getAllOrder();
			List<Order> s = shop.listCompletedOrder(orderListCompleted);
			view.showListCompletedOrders(s);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
	}
	
	public void showCountCompletedOrders() {
		try {
			Order[] orderCountCompleted = shop.getAllOrder();
			int count = shop.countCompletedOrder(orderCountCompleted);
			view.showCountCompletedOrders(count);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	
	public void showSortListCompletedOrderByDate() {
		
		Order[] orderListCompleted;
		try {
			orderListCompleted = shop.getAllOrder();
			List<Order> s = shop.listCompletedOrder(orderListCompleted);
			s = shop.sortListCompletedOrderByDate(s);
			view.showSortListCompletedOrderByDate(s);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	
	public void showSortListCompletedOrderByCost() {
		Order[] orderListCompleted;
		try {
			orderListCompleted = shop.getAllOrder();
			List<Order> s = shop.listCompletedOrder(orderListCompleted);
			s = shop.sortListCompletedOrderByCost(s);
			view.showSortListCompletedOrderByCost(s);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	public void showSumOrders() {
		Order[] orderSum;
		try {
			orderSum = shop.getAllOrder();
			double sum = shop.sumOrder(orderSum);
			view.showSumOrders(sum);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	public void showCountRequestBooks() {
		String str = "Alchemist";
	 	String str1 = "Great Gatsby";
	 	Order[] countRequestBooks;
		try {
			countRequestBooks = shop.getAllOrder();
			Integer n1 = shop.countRequest(countRequestBooks, str);
			Integer n2 = shop.countRequest(countRequestBooks, str1);
			view.showCountRequestBooks(n1,n2);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	
	public void showSortCountRequestBooks() {
		String str = "Alchemist";
	 	String str1 = "Great Gatsby";
	 	Order[] countRequestBooks;
		try {
			countRequestBooks = shop.getAllOrder();
			Integer n1 = shop.countRequest(countRequestBooks, str);
			Integer n2 = shop.countRequest(countRequestBooks, str1);
			List<Integer> array = shop.sortCountRequest(n1, n2);
			view.showSortCountRequestBooks(array);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}
	
	
	public void showSortAlphRequestBooks() {
		String str = "Alchemist";
	 	String str1 = "Great Gatsby";
	 	Order[] sortAlp;
		try {
			sortAlp = shop.getAllOrder();
			List<Order> array = shop.methodAlphabeticallyForSort(sortAlp, str,str1);
			array = shop.sortAlphabetically(array);
			view.showSortAlphRequestBooks(array);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
		
	}

	public void orderListStaleBook() {
		List<Order> list = new ArrayList<Order>();
		Order[] orderListStaleBook = shop.getAllOrder();
		list = shop.listStaleOrder(orderListStaleBook);
		view.orderListStaleBook(list);
	}
	
	
	
}
