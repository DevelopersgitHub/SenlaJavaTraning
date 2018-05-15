package com.senla.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.fileutil.BookFileUtil;
import com.senla.fileutil.OrderFileUtil;
import com.senla.model.Book;
import com.senla.model.Client;
import com.senla.model.Order;

public class Shop implements IShop{

	final BookFileUtil util = new BookFileUtil();
	final OrderFileUtil util2 = new OrderFileUtil();
	
	private IBookService bookService = new BookService();
	private IOrderService orderService = new OrderService();
	private IClientService clientService = new ClientService();
	
	public Shop() {
	}

	public IBookService getBookService() {
		return bookService;
	}
	
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	public IClientService getClientService() {
		return clientService;
	}
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
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

	public void updateBook(Book book) {
		bookService.addBook(book);
	}
	
	public void updateOrder(Order order) {
		orderService.addOrder(order);
	}
	
	public void updateClient(Client client) {
		clientService.addClient(client);
	}

	public void removeBook(Book book) {
		bookService.removeBook(book);
		
	}

	public void removeOrder(Order order) {
		orderService.removeOrder(order);
		
	}

	public void removeClient(Client client) {
		clientService.removeClient(client);
		
	}

	public Book getBook() throws NumberFormatException, ParseException {
		return bookService.getBook();
		
	}

	public Order getOrder() throws NumberFormatException, ParseException {
		return orderService.getOrder();
		
	}

	public Client getClient() throws NumberFormatException, ParseException {
		return clientService.getClient();
		
	}

	public Book[] getAllBook() throws NumberFormatException, ParseException {
		return bookService.getAllBook();
		
	}

	public Order[] getAllOrder() throws NumberFormatException, ParseException {
		return orderService.getAllOrder();
		
	}

	public Client[] getAllClient() throws NumberFormatException, ParseException {
		return clientService.getAllClient();
		
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
	
	public String bookDescription(Book bk, long idBook){
		if (bk == null) {
			throw new IllegalArgumentException();
		}
		String s = null;
		if(bk.getBookID() == idBook) {
			s = bk.getBookName() + "\nDescription of books: " + bk.getBookDescription();
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
	
	
	public String orderDetails(Order ord, Long idOrder) {
		if (ord == null) {
			throw new IllegalArgumentException();
		}
		String s = null;
		if(ord.getID() == idOrder) {
			s = ord.getID() + ", " + ord.getOrderContent() + ", " + ord.getOrderExecutionDate() + ", " + ord.getOrderCost() + ", " + ord.getOrderStatus();
		}
		return s;
	}
	
	public void orderDetails(Order ord) {
		System.out.println(ord.getID() + ", " + ord.getOrderContent() + ", " + ord.getOrderExecutionDate() + ", " + ord.getOrderCost() + ", " + ord.getOrderStatus());
	}
	
	private static Date parseDate(String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
	
	
	public int countCompletedOrder(Order[] oc) throws NumberFormatException, ParseException {
		String date = "11/12/2011";
		Date currentDate = parseDate(date,"dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final String MORNING_FIRST = "10/08/2011";
        final String MORNING_SECOND = "15/12/2018";
        Date current = dateFormat.parse(dateFormat.format(currentDate));
        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
        Date morningSecond = dateFormat.parse(MORNING_SECOND);
        
		String str = "Completed";
		int count = 0;
		for(int i=0;i<oc.length;i++) {
			if((oc[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
				count++;
			}
		}
		return count;
	}
	

	public List<Order> listCompletedOrder(Order[] orderListCompleted) throws ParseException{
		String date = "11/12/2011";
		Date currentDate;
		List<Order> s = new ArrayList<Order>();
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
		return s;
		
	}
	public double sumOrder(Order[] orderSum) throws ParseException {
		String date = "11/12/2011";
		Date currentDate = parseDate(date,"dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final String MORNING_FIRST = "10/08/2011";
        final String MORNING_SECOND = "15/12/2018";
        Date current = dateFormat.parse(dateFormat.format(currentDate));
        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
        Date morningSecond = dateFormat.parse(MORNING_SECOND);

		double sum = 0;
		String str = "Completed";
		for(int i=0;i<orderSum.length;i++) {
			if((orderSum[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
				sum+=orderSum[i].getOrderCost();
			}
		}
		return sum;
	}
	
	public int countRequest(Order[] persons, String str) {
		int count = 0;
		for(int i = 0; i < persons.length; i++){
			String str1 = persons[i].getOrderContent();
			if(str.equals(str1)){
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
	
	public List<Order> listStaleOrder(Order[] orderListCompleted) throws ParseException {
		if (orderListCompleted == null) {
			throw new IllegalArgumentException();
		}
		String date = "11/12/2011";
		Date currentDate;
		List<Order> list = new ArrayList<Order>();
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

}



