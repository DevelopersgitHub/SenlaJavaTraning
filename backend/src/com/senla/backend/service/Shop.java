package com.senla.backend.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.backend.csv.CSVUtil;
import com.senla.backend.csv.ICSVUtil;
import com.senla.backend.dto.DTO;
import com.senla.backend.fileutil.BookFileUtil;
import com.senla.backend.fileutil.ClientFileUtil;
import com.senla.backend.fileutil.OrderFileUtil;
import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;
import com.senla.backend.serialization.ISerializationUtil;
import com.senla.backend.serialization.SerializationUtil;
import com.senla.di.DI;

public class Shop implements IShop {
	private static final Logger LOGGER = LogManager.getLogger(Shop.class.getSimpleName());
	private static Scanner scanner = new Scanner(System.in);
	private ICSVUtil csvUtil = new CSVUtil();
	private ISerializationUtil serializationUtil = new SerializationUtil();
	final BookFileUtil utilBooks = new BookFileUtil();
	final OrderFileUtil utilOrders = new OrderFileUtil();
	final ClientFileUtil utilClients = new ClientFileUtil();
	
	private IBookService bookService;
	private IOrderService orderService;
	private IClientService clientService;
	
	public Shop() {
		bookService = DI.configure(IBookService.class);
		orderService = DI.configure(IOrderService.class);
		clientService = DI.configure(IClientService.class);
	}
	
	public void addBook(Book book) {
		bookService.addBook(book);
	}
	  
	public void addOrder(Order order) {
		 orderService.addOrder(order);
	}

	public void addClient(Client client) {
		clientService.addClient(client);
		
	}

	public void updateBook(Long id, Book book) {
		bookService.updateBook(id, book);
	}
	
	public void updateOrder(Long id, String status, Order[] order) {
		orderService.updateOrder(id, status, order);
	}
	
	public void updateClient(Long id, Client client) {
		clientService.updateClient(id, client);
	}

	public void removeBook(Long id) {
		bookService.removeBook(id);
	}

	public void removeOrder(Long id) {
		orderService.removeOrder(id);
		
	}

	public void removeClient(Long id) {
		clientService.removeClient(id);
		
	}

	public Book getBook(Book[] book, Long id) {
		return bookService.getBook(book, id);
		
	}

	public Order getOrder(Order[] order, Long id) {
		return orderService.getOrder(order, id);
		
	}

	public Client getClient(Client[] client, Long id) {
		return clientService.getClient(id);
		
	}

	public List<Book> getAllBook() {
		return bookService.getAllBook();
		
	}

	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
		
	}

	public List<Client> getAllClient() {
		return clientService.getAllClient();
		
	}

	public Book[] loadBook() {
		return bookService.loadBook();
		
	}
	
	public void saveBook(Book[] books) {
		bookService.saveBook(books);
	}
	
	
	
	public Order[] loadOrder() {
		return orderService.loadOrder();
		
	}
	
	public void saveOrder(Order[] orders) {
		orderService.saveOrder(orders);
	}
	
	
	
	public Client[] loadClient() {
		return clientService.loadClient();
		
	}
	
	public void saveClient(Client[] clients) {
		clientService.saveClient(clients);
	}
	
	public Book[] sortNameBook(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookName().compareTo(o2.getBookName());
				}
			});
		return readedValues;
		}
	
	public Book[] sortDatePublic(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookDatePublic().compareTo(o2.getBookDatePublic());
				}
			});
		return readedValues;
		}
	
	public Book[] sortCost(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookCost().compareTo(o2.getBookCost());
				}
			});
		return readedValues;
		}
	
	public Book[] sortPresense(Book[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getBookPresence().compareTo(o2.getBookPresence());
				}
			});
		return readedValues;
		}
	
	public String bookDescription(Book[] bk, Long idBook){
		String s = null;
		for(int i = 0; i<bk.length;i++) {
		if(bk[i].getBookID().equals(idBook)) {
				s = bk[i].getBookName() + "\nDescription of books: " + bk[i].getBookDescription();
			}
		}
		return s;
	}
	
	public Order[] sortDateExecution(Order[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderExecutionDate().compareTo(o2.getOrderExecutionDate());
				}
			});
		return readedValues;
		}
	public Order[] sortCostOrder(Order[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderCost().compareTo(o2.getOrderCost());
				}
			});
		return readedValues;
		}
	public Order[] sortStatus(Order[] readedValues) {
		Arrays.sort(readedValues, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderStatus().compareTo(o2.getOrderStatus());
				}
			});
		return readedValues;
		}
	
	
	public String orderDetails(Order order, Long idOrder) {
		if (order == null) {
			throw new IllegalArgumentException();
		}
		String s = null;
		if(order.getID().equals(idOrder)) {
			s = order.getID() + ", " + order.getOrderContent() + ", " + order.getOrderExecutionDate() + ", " + order.getOrderCost() + ", " + order.getOrderStatus();
		}
		return s;
	}
	
	public void orderDetails(Order order) {
		System.out.println(order.getID() + ", " + order.getOrderContent() + ", " + order.getOrderExecutionDate() + ", " + order.getOrderCost() + ", " + order.getOrderStatus());
	}
	
	private static Date parseDate(String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
	
	
	public int countCompletedOrder(Order[] order) {
		String date = "11/12/2011";
		Date currentDate;
		int count = 0;
		try {
			currentDate = parseDate(date,"dd/MM/yyyy");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        final String MORNING_FIRST = "10/08/2011";
	        final String MORNING_SECOND = "15/12/2018";
	        Date current = dateFormat.parse(dateFormat.format(currentDate));
	        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
	        Date morningSecond = dateFormat.parse(MORNING_SECOND);
			String str = "Completed";
			for(int i=0;i<order.length;i++) {
				if((order[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
					count++;
				}
			}
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
       
		return count;
	}
	

	public List<Order> listCompletedOrder(Order[] orderListCompleted){
		String date = "11/12/2011";
		Date currentDate;
		List<Order> s = new ArrayList<Order>();
		try {
			currentDate = parseDate(date,"dd/MM/yyyy");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        final String MORNING_FIRST = "10/08/2011";
	        final String MORNING_SECOND = "15/12/2018";
	        Date current = dateFormat.parse(dateFormat.format(currentDate));
	        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
	        Date morningSecond = dateFormat.parse(MORNING_SECOND);
	        String str = "Completed";
			for(int i=0;i<orderListCompleted.length;i++) {
				if((orderListCompleted[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
					s.add(orderListCompleted[i]);
				}
			}
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		
		return s;
		
	}
	public double sumOrder(Order[] orderSum) {
		String date = "11/12/2011";
		Date currentDate;
		double sum = 0;
		try {
			currentDate = parseDate(date,"dd/MM/yyyy");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        final String MORNING_FIRST = "10/08/2011";
	        final String MORNING_SECOND = "15/12/2018";
	        Date current = dateFormat.parse(dateFormat.format(currentDate));
	        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
	        Date morningSecond = dateFormat.parse(MORNING_SECOND);
			String str = "Completed";
			for(int i=0;i<orderSum.length;i++) {
				if((orderSum[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
					sum+=orderSum[i].getOrderCost();
				}
			}
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return sum;
	}
	
	public int countRequest(Order[] orders, String str) {
		int count = 0;
		for(int i = 0; i < orders.length; i++){
			if(orders[i].getOrderContent().equals(str)){
				count++;
			}
		}
		return count;
	}
	public List<Integer> sortCountRequest(Integer n1, Integer n2) {
		if (n1 == null && n2 == null) {
			throw new IllegalArgumentException();
		}
		List<Integer> array = new ArrayList<Integer>();
		array.add(n1);
		array.add(n2);
		Collections.sort(array, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
				}
			});
		return array;
	}
	
	public void sortAlphabetically(Order[] persons,String str) {
		Arrays.sort(persons, new Comparator<Order>() {
		        public int compare(Order o1, Order o2) {
		                return o1.getOrderContent().compareTo(o2.getOrderContent());
		        }
		});
		for (int i = 0; i < persons.length; i++ ){
			String str1 = persons[i].getOrderContent();
			if(str.equals(str1)){
			System.out.println((i+1) +") " + "ID of orders = " + persons[i].getID() + "; " + persons[i].getOrderContent());
			}
		}
	}
	
	public List<Order> methodAlphabeticallyForSort(Order[] persons,String str, String str1){
		List<Order> o = new ArrayList<Order>(); 
		for (int i = 0; i < persons.length; i++ ){
		String str2 = persons[i].getOrderContent();
		if(str.equals(str2) || str1.equals(str2) ){
			o.add(persons[i]);
		} 
	}
		return o;	
	}
	
	
	public List<Order> sortAlphabetically(List<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderContent().compareTo(o2.getOrderContent());
				}
			});
		return s;
	}
	
	public List<Order> listStaleOrder(Order[] orderListCompleted) {
		if (orderListCompleted == null) {
			throw new IllegalArgumentException();
		}
		String date = "11/12/2011";
		Date currentDate;
		List<Order> list = new ArrayList<Order>();
		try {
			currentDate = parseDate(date,"dd/MM/yyyy");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        final String MORNING_FIRST = "10/08/2011";
	        final String MORNING_SECOND = "15/12/2018";
	        Date current = dateFormat.parse(dateFormat.format(currentDate));
	        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
	        Date morningSecond = dateFormat.parse(MORNING_SECOND);
			String str = "Completed";
			for(int i=0;i<orderListCompleted.length;i++) {
				if((!(orderListCompleted[i].getOrderStatus()).equals(str)) && (current.after(morningFirst) && current.before(morningSecond))) {
						list.add(orderListCompleted[i]);
					}
				}
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(),  e);
		}
	 	
		return list;
	}

	public List<Order> sortListCompletedOrderByDate(List<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
		        public int compare(Order o1, Order o2) {
		                return o1.getOrderExecutionDate().compareTo(o2.getOrderExecutionDate());
		        }
		});
		return s;
	}

	public List<Order> sortListCompletedOrderByCost(List<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
	        public int compare(Order o1, Order o2) {
	                return o1.getOrderCost().compareTo(o2.getOrderCost());
	        }
		});
		return s;
	}

	public List<Order> sortListUnsoldBookByDate(List<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
	        public int compare(Order o1, Order o2) {
	                return o1.getOrderExecutionDate().compareTo(o2.getOrderExecutionDate());
	        }
		});
		return s;
	}

	public List<Order> sortListUnsoldBookByCost(List<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
	        public int compare(Order o1, Order o2) {
	                return o1.getOrderCost().compareTo(o2.getOrderCost());
	        }
		});
		return s;
	}

	public void countMonthWait(Integer month ) {
		int countMonthForStale = 6;
		System.out.println("\nEnter order id: \n");
		Long id = scanner.nextLong();
		String status = "Waiting for processing";
		Order[] order = orderService.loadOrder();
		for(int i = 0; i<order.length;i++) {
			if(month.equals(countMonthForStale)) {
				orderService.updateOrder(id, status, order);
				orderService.saveOrder(order);
			}
		}
		
	}
	
	public boolean powerOrdersCompeled(Boolean value) {
		String status = "Completed";
		System.out.println("\nEnter order id: \n");
		Long id = scanner.nextLong();
		Order[] orders = orderService.loadOrder();
		for(int i = 0; i<orders.length;i++) {
			if(value) {
				orderService.updateOrder(id, status, orders);
				orderService.saveOrder(orders);
				return true;
			}
		}
		return false;
	}

	public List<Order> cloneOrder(Order[] orders) {
		List<Order> orderList;
		orderList = orderService.cloneOrder(orders);
		return orderList;
	}
	
	public void importCSV() {
		List<Book> list = csvUtil.importCSV();
		for(Book book : list) {
			if(book.getBookID() == null) {
				bookService.addBook(book);
			}
			else {
				bookService.updateBook(book.getBookID(), book);
			}
		}
	}
	
	public void exportCSV() {
		List<Book> list = Arrays.asList(bookService.loadBook());
		for(Book book : list) {
			if(book.getBookID() == null) {
				csvUtil.exportCSV(book);
			}
		}
	}
	
	public void serialization() {
		List<Book> books = Arrays.asList(bookService.loadBook());
		List<Order> orders = Arrays.asList(orderService.loadOrder());
		List<Client> clients = Arrays.asList(clientService.loadClient());
		DTO dto = new DTO(books,orders,clients);
		serializationUtil.serialization(dto);
	}
	
	public DTO deserialization() {
		DTO dto = serializationUtil.deserialization();
		dto.getBooks();
		dto.getOrders();
		dto.getClients();
		bookService.saveBook(dto.getBooks().stream().toArray(Book[]::new));
		orderService.saveOrder(dto.getOrders().stream().toArray(Order[]::new));
		clientService.saveClient(dto.getClients().stream().toArray(Client[]::new));
		return dto;
	}
}



