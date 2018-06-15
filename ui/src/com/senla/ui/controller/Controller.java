package com.senla.ui.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.dto.DTO;
import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;
import com.senla.backend.service.IShop;
import com.senla.backend.service.Shop;
import com.senla.di.DI;
import com.senla.ui.view.ConsoleView;
import com.senla.ui.view.IView;

public class Controller implements IController {
	private static final Logger LOGGER = LogManager.getLogger(Controller.class.getSimpleName());
	private static Scanner scanner = new Scanner(System.in);
	private static IController instance; 
	
	IShop shop = (IShop) DI.configure(Shop.class);
	IView view = new ConsoleView();
	
	private Controller() {
		
	}
	public static IController getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	public void addBook() {
		Book book = null;
		try {
			System.out.println("\nEnter the book ID, name, date of public(day//month//year), cost, presence and description: \n");
			Long idBook = scanner.nextLong();
			String name = scanner.next();
			String dateBook = scanner.next();
			String costBook = scanner.next();
			Double costAddBook = Double.parseDouble(costBook);
			String presence = scanner.next();
			String descriptionBook = scanner.next();
			book = new Book(idBook, name, parseDate(dateBook, "dd//MM//yyyy"), costAddBook, Boolean.parseBoolean(presence), descriptionBook);
			shop.addBook(book);
			view.addBook(book);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	public static Date parseDate (String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}

	public void getBook() {
		Book book = null;
		System.out.println("\nEnter the book ID: \n");
		Long idBook = scanner.nextLong();
		book = shop.getBook(shop.loadBook(), idBook);
		view.getBook(book);
	}

	public void getAllBook() {
		List<Book> book = shop.getAllBook();
		view.getAllBook(book);
	}

	public void updateBook() {
		Book book = null;
		Long number = 0L;
		try {
				System.out.println("\nEnter the book ID: \n");
				String idBook = scanner.next();
				number = Long.parseLong(idBook);
				book = shop.getBook(shop.loadBook(), number);
				shop.updateBook(1L, book);
				view.updateBook(book);
		} catch(Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void removeBook() {
		Book book = null;
		Long number = 0L;
		try {
			System.out.println("\nEnter the book ID: \n");
			String idBook = scanner.next();
			number = Long.parseLong(idBook);
			book = shop.getBook(shop.loadBook(), number);
			shop.removeBook(number);
			view.removeBook(book);
		} catch(Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void addOrder() {
		Order order = null;
		try {
			System.out.println("\nEnter the order ID, content, date of execution (day//month//year), cost, status: \n");
			Long idOrder = scanner.nextLong();
			String content = scanner.next();
			String dateOrder = scanner.next();
			String costOrder = scanner.next();
			String statusOrder = scanner.next();
			order = new Order(idOrder,content, parseDate(dateOrder,"dd//MM//yyyy"), Double.parseDouble(costOrder), statusOrder);
			shop.addOrder(order);
			view.addOrder(order);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void getOrder() {
		Long number;
		try {
			System.out.println("\nEnter the order ID: \n");
			String idOrder = scanner.next();
			number = Long.parseLong(idOrder);
			Order order = shop.getOrder(shop.loadOrder(), number);
			view.getOrder(order);
		} catch(Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void getAllOrder() {
		List<Order> order = shop.getAllOrder();
		view.getAllOrder(order);
	}

	public void updateOrder() {
		Order order = null;
		Order[] orders = null;
		Long number;
		try {
			System.out.println("\nEnter the order ID: \n");
			String idOrder = scanner.next();
			number = Long.parseLong(idOrder);
			orders = shop.loadOrder();
			order = shop.getOrder(orders, number);
			shop.updateOrder(number, "Waiting for processing", orders);
			view.updateOrder(order);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void removeOrder() {
		System.out.println("\nEnter the order ID: \n");
		Long id = scanner.nextLong();
		shop.removeOrder(id);
		view.removeOrder(id);
	}

	public void addClient() {
		Client client = null;
		try {
			System.out.println("\nEnter the client ID and name: \n");
			String idClient = scanner.next();
			Long id = Long.parseLong(idClient);
			String nameClient = scanner.next();
			client = new Client(id, nameClient);
			shop.addClient(client);
			view.addClient(client);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void getClient() {
		Client client = null;
		Long number = 0L;
		try {
			System.out.println("\nEnter the client ID: \n");
			String idClient = scanner.next();
			number = Long.parseLong(idClient);
			client = shop.getClient(shop.loadClient(), number);
			view.getClient(client);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}

	public void getAllClient() {
		List<Client> client = shop.getAllClient();
		view.getAllClient(client);
	}

	public void updateClient() {
		Client client = null;
		try{
			System.out.println("\nEnter the client ID: \n");
			String idClient = scanner.next();
			Long number = Long.parseLong(idClient);
			client = shop.getClient(shop.loadClient(), number);
			shop.updateClient(number, client);
			view.updateClient(client);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}

	public void removeClient() {
		Client client = null;
		client = new Client(1L,"Build");
		shop.removeClient(1L);
		view.removeClient(client);
	}


	public void loadBook() {
		Book[] book = null;
		book = shop.loadBook();
		view.loadBook(book);
		
	}

	public void loadOrder() {
		Order[] order = null;
		order = shop.loadOrder();
		view.loadOrder(order);
	}

	public void loadClient() {
		Client[] client = null;
		client = shop.loadClient();
		view.loadClient(client);
	}

	public void saveBook() {
		Book[] book = null;
		book = shop.loadBook();
		shop.saveBook(book);
		view.saveBook(book);
	}

	public void saveOrder() {
		Order[] order = null;
		order = shop.loadOrder();
		shop.saveOrder(order);
		view.saveOrder(order);
	}

	public void saveClient() {
		Client[] client = null;
		client = shop.loadClient();
		shop.saveClient(client);
		view.saveClient(client);
	}
	
	public void showBooks() {
		Book[] books;
		try {
			books = shop.loadBook();
			view.showBooks(books);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}

	public void showOrders() {
		Order[] orders;
		try {
			orders = shop.loadOrder();
			view.showOrders(orders);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	public void showClients()  {
		Client[] clients;
		try {
			clients = shop.loadClient();
			view.showClients(clients);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	};

	public void showSortNameBook()  {
		Book[] booksSort;
		try {
			booksSort = shop.loadBook();
			booksSort = shop.sortNameBook(booksSort);
			view.showSortNameBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		} catch (SecurityException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	public void showSortDatePublicBook() {
		Book[] booksSort;
		try {
			booksSort = shop.loadBook();
			booksSort = shop.sortDatePublic(booksSort);
			view.showSortDatePublicBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormatException" + e.getClass());
		}
	}

	public void showSortCostBook() {
		Book[] booksSort;
		try {
			booksSort = shop.loadBook();
			booksSort = shop.sortCost(booksSort);
			view.showSortCostBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	public void showSortPresenceBook() {
		Book[] booksSort;
		try {
			booksSort = shop.loadBook();
			booksSort = shop.sortPresense(booksSort);
			view.showSortPresenceBook(booksSort);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	
	public void showSortDateExecutionOrder() {
		Order[] orderSort;
		try {
			orderSort = shop.loadOrder();
			orderSort = shop.sortDateExecution(orderSort);
			view.showSortDateExecutionOrder(orderSort);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	public void showSortCostOrder() {
		Order[] orderSort;
		try {
			orderSort = shop.loadOrder();
			orderSort = shop.sortCostOrder(orderSort);
			view.showSortCostOrder(orderSort);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	public void showSortStatusOrder() {
		Order[] orderSort;
		try {
			orderSort = shop.loadOrder();
			orderSort = shop.sortStatus(orderSort);
			view.showSortStatusOrder(orderSort);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
		
	public void showOrderDetails() {
		Order[] order = null;
		Long number;
		Order ordersDetails = null;
		try {
			System.out.println("\nEnter the order ID: \n");
			String idOrder = scanner.next();
			number = Long.parseLong(idOrder);
			order = shop.loadOrder();
			ordersDetails = shop.getOrder(order, number);
			String s = shop.orderDetails(ordersDetails, number);
			view.showOrderDetails(s);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	public void showBookDescription() {
		Book[] book;
		try {
			System.out.println("\nEnter the book ID: \n");
			Long idOrder = scanner.nextLong();
			book = shop.loadBook();
			String s = shop.bookDescription(book, idOrder);
			view.showBookDescription(s);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	public void showListCompletedOrders() {
		try {
			Order[] orderListCompleted = shop.loadOrder();
			List<Order> s = shop.listCompletedOrder(orderListCompleted);
			view.showListCompletedOrders(s);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	
	public void showCountCompletedOrders() {
		try {
			Order[] orderCountCompleted = shop.loadOrder();
			int count = shop.countCompletedOrder(orderCountCompleted);
			view.showCountCompletedOrders(count);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	
	public void showSortListCompletedOrderByDate() {
		
		Order[] orderListCompleted;
		try {
			orderListCompleted = shop.loadOrder();
			List<Order> s = shop.listCompletedOrder(orderListCompleted);
			s = shop.sortListCompletedOrderByDate(s);
			view.showSortListCompletedOrderByDate(s);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	
	public void showSortListCompletedOrderByCost() {
		Order[] orderListCompleted;
		try {
			orderListCompleted = shop.loadOrder();
			List<Order> s = shop.listCompletedOrder(orderListCompleted);
			s = shop.sortListCompletedOrderByCost(s);
			view.showSortListCompletedOrderByCost(s);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	public void showSumOrders() {
		Order[] orderSum;
		try {
			orderSum = shop.loadOrder();
			double sum = shop.sumOrder(orderSum);
			view.showSumOrders(sum);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	public void showCountRequestBooks() {
	 	Order[] countRequestBooks;
		try {
			System.out.println("Enter the name of the first book: ");
			String str = scanner.next();
			System.out.println("Enter the name of the second book: ");
		 	String str1 = scanner.next();
			countRequestBooks = shop.loadOrder();
			Integer n1 = shop.countRequest(countRequestBooks, str);
			Integer n2 = shop.countRequest(countRequestBooks, str1);
			view.showCountRequestBooks(n1,n2,str,str1);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	}
	
	public void showSortCountRequestBooks() {
	 	Order[] countRequestBooks;
		try {
			System.out.println("Enter the name of the first book: ");
			String str = scanner.next();
			System.out.println("Enter the name of the second book: ");
		 	String str1 = scanner.next();
			countRequestBooks = shop.loadOrder();
			Integer n1 = shop.countRequest(countRequestBooks, str);
			Integer n2 = shop.countRequest(countRequestBooks, str1);
			List<Integer> array = shop.sortCountRequest(n1, n2);
			view.showSortCountRequestBooks(array);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}
	
	
	public void showSortAlphRequestBooks() {
		System.out.println("Enter the name of the first book: ");
		String str = scanner.next();
		System.out.println("Enter the name of the second book: ");
	 	String str1 = scanner.next();
	 	Order[] sortAlp;
		try {
			sortAlp = shop.loadOrder();
			List<Order> array = shop.methodAlphabeticallyForSort(sortAlp, str,str1);
			array = shop.sortAlphabetically(array);
			view.showSortAlphRequestBooks(array);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
	}

	public void orderListStaleBook() {
		List<Order> list = new ArrayList<Order>();
		Order[] orderListStaleBook = shop.loadOrder();
		list = shop.listStaleOrder(orderListStaleBook);
		view.orderListStaleBook(list);
	}
	

	public void showCloneOrder() {
		Order[] orders = shop.loadOrder();
		Order[] orderClone = orders.clone();
		view.showCloneOrder(orderClone);
	}
	
	public void showImport() {
		shop.importCSV();
		view.showImport(Arrays.asList(shop.loadBook()));
	}

	public void showExport() {
		shop.exportCSV();
		view.showExport();
	}

	public void showSerialization() {
		shop.serialization();
		view.showSerialization();
	}
	
	public void showDeserialization() {
		DTO bookSerial = shop.deserialization();
		view.showDeserialization(bookSerial);
	}
}
