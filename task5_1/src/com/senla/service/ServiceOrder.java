package com.senla.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.senla.controller.Main;
import com.senla.fileutil.OrderFileUtil;
import com.senla.logger.MyLogger;
import com.senla.model.Order;

public class ServiceOrder implements IServiceOrder{
	public Order[] sortDateExecution(Order[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderExecutionDate().compareTo(o2.getOrderExecutionDate());
				}
			});
		return readedValues;
		}
	
	public Order[] sortCostOrder(Order[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderCost().compareTo(o2.getOrderCost());
				}
			});
		return readedValues;
		}
	
	public Order[] sortStatus(Order[] readedValues) {
		if (readedValues == null) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(readedValues, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderStatus().compareTo(o2.getOrderStatus());
				}
			});
		return readedValues;
		}
	
	final OrderFileUtil util = new OrderFileUtil();
	public Order orderDetails() {
		Order ord = new Order();
		Order[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				if(ord.getID() == 1) {
					ord = readedValues[0];
				}
			}
		} catch (NumberFormatException e) {
			MyLogger.logger.info("NumberFormatException: " + e.getClass());
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		} catch (IOException e) {
			MyLogger.logger.info("IOException: " + e.getClass());
		}
		return ord;
	}
	
	public void orderDetails(Order ord) {
		if (ord == null) {
			throw new IllegalArgumentException();
		}
		System.out.println(ord.getID() + ", " + ord.getOrderContent() + ", " + ord.getOrderExecutionDate() + ", " + ord.getOrderCost() + ", " + ord.getOrderStatus());
	}
	
	private static Date parseDate(String date, String format) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    return formatter.parse(date);
	}
	
	
	public int countCompletedOrder(Order[] oc) {
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
			for(int i=0;i<oc.length;i++) {
				if((oc[i].getOrderStatus()).equals(str) && (current.after(morningFirst) && current.before(morningSecond))) {
					count++;
				}
			}
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		} 
       
		return count;
	}
	

	public void listCompletedOrder(Order[] orderListCompleted) {
		String date = "11/12/2011";
		Date currentDate;
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
					System.out.println(orderListCompleted[i].getID() + ", Data of execution orders: "+ orderListCompleted[i].getOrderExecutionDate() + ", Cost of orders: " + orderListCompleted[i].getOrderCost());
				}
			}
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		} 
        
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
			MyLogger.logger.info("ParseException: " + e.getClass());
		} 
       
		return Math.round(sum);
	}
	
	public int countRequest(Order[] persons, String str) {
		if (persons == null && str == null) {
			throw new IllegalArgumentException();
		}
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
		if (n1 == null && n2 == null) {
			throw new IllegalArgumentException();
		}
		if(n1.compareTo(n2) == 1) {
			System.out.println("Count of requests for first of book: " + n1);
		}
		System.out.println("Count of requests for second of book: " + n2);
	}
	
	public void sortAlphabetically(Order[] persons,String str) {
		if (persons == null && str == null) {
			throw new IllegalArgumentException();
		}
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
	
	
	public void listStaleOrder(Order[] orderListCompleted) {
		if (orderListCompleted == null) {
			throw new IllegalArgumentException();
		}
		String date = "11/12/2011";
		Date currentDate;
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
					System.out.println("ID orders: " + orderListCompleted[i].getID() + " Book: " + orderListCompleted[i].getOrderContent() + ", Data of execution orders: "+ orderListCompleted[i].getOrderExecutionDate() + ", Cost of orders: " + orderListCompleted[i].getOrderCost());
					}
				}
		} catch (ParseException e) {
			MyLogger.logger.info("ParseException: " + e.getClass());
		} 
	}
}


