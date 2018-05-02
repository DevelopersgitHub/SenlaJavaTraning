package com.senla.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.senla.fileutil.OrderFileUtil;
import com.senla.model.Book;
import com.senla.model.Order;

public class ServiceOrder implements IServiceOrder{
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
	
	final OrderFileUtil util = new OrderFileUtil();
	public Order orderDetails() throws NumberFormatException, ParseException {
		Order ord = new Order();
		final Order[] readedValues = util.readFromFile();
		for(int i=0;i<readedValues.length;i++) {
			if(ord.getID() == 1) {
				ord = readedValues[0];
			}
		}
		return ord;
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
	

	public void listCompletedOrder(Order[] orderListCompleted) throws ParseException {
		String date = "11/12/2011";
		Date currentDate = parseDate(date,"dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final String MORNING_FIRST = "10/08/2011";
        final String MORNING_SECOND = "15/12/2018";
        Date current = dateFormat.parse(dateFormat.format(currentDate));
        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
        Date morningSecond = dateFormat.parse(MORNING_SECOND);
        
		String str = "Completed";
		for(int i=0;i<orderListCompleted.length;i++) {
			if((orderListCompleted[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
				System.out.println(orderListCompleted[i].getID() + ", Data of execution orders: "+ orderListCompleted[i].getOrderExecutionDate() + ", Cost of orders: " + orderListCompleted[i].getOrderCost());
			}
		}
		
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
		return Math.round(sum);
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
	public void sortCountRequest(Integer n1, Integer n2) {
		if(n1.compareTo(n2) == 1) {
			System.out.println("Count of requests for first of book: " + n1);
		}
		System.out.println("Count of requests for second of book: " + n2);
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
	
	public void listStaleOrder(Order[] orderListCompleted) throws ParseException {
		String date = "11/12/2011";
		Date currentDate = parseDate(date,"dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final String MORNING_FIRST = "10/08/2011";
        final String MORNING_SECOND = "15/12/2018";
        Date current = dateFormat.parse(dateFormat.format(currentDate));
        Date morningFirst  = dateFormat.parse(MORNING_FIRST);
        Date morningSecond = dateFormat.parse(MORNING_SECOND);
		String str = "Completed";
		
		for(int i=0;i<orderListCompleted.length;i++) {
			if((!(orderListCompleted[i].getOrderStatus()).equals(str)) && (current.after(morningFirst) && current.before(morningSecond))) {
				System.out.println("ID orders: " + orderListCompleted[i].getID() + " Book: " + orderListCompleted[i].getOrderContent() + ", Data of execution orders: "+ orderListCompleted[i].getOrderExecutionDate() + ", Cost of orders: " + orderListCompleted[i].getOrderCost());
			}
		}
	}
}


