package com.senla.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
	public Order orderDetails() throws NumberFormatException, ParseException {
		Order ord = new Order();
		Order[] readedValues;
		try {
			readedValues = util.readFromFile();
			for(int i=0;i<readedValues.length;i++) {
				if(ord.getID() == 1) {
					ord = readedValues[0];
				}
			}
		} catch (IOException e) {
			MyLogger.logger.info("IOException: " + e.getClass());
		}
		return ord;
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
	

	public ArrayList<Order> listCompletedOrder(Order[] orderListCompleted){
		String date = "11/12/2011";
		Date currentDate;
		ArrayList<Order> s = new ArrayList<Order>();
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
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		return s;
	}
	public double sumOrder(Order[] orderSum){
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
	public ArrayList<Integer> sortCountRequest(Integer n1, Integer n2) {
		if (n1 == null && n2 == null) {
			throw new IllegalArgumentException();
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(n1);
		array.add(n2);
		Collections.sort(array, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
				}
			});
		return array;
	}
	
	public ArrayList<Order> methodAlphabeticallyForSort(Order[] persons,String str, String str1){
		ArrayList<Order> o = new ArrayList<Order>(); 
		for (int i = 0; i < persons.length; i++ ){
		String str2 = persons[i].getOrderContent();
		if(str.equals(str2) || str1.equals(str2) ){
			o.add(persons[i]);
		} 
	}
		return o;	
	}
	
	
	public ArrayList<Order> sortAlphabetically(ArrayList<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getOrderContent().compareTo(o2.getOrderContent());
				}
			});
		return s;
	}
	
	
	public ArrayList<Order> listStaleOrder(Order[] orderListCompleted) {
		if (orderListCompleted == null) {
			throw new IllegalArgumentException();
		}
		String date = "11/12/2011";
		Date currentDate;
		ArrayList<Order> list = new ArrayList<Order>();
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
			MyLogger.logger.info("ParseException: " + e.getClass());
		}
		return list;
	}

	public ArrayList<Order> sortListCompletedOrderByDate(ArrayList<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
		        public int compare(Order o1, Order o2) {
		                return o1.getOrderExecutionDate().compareTo(o2.getOrderExecutionDate());
		        }
		});
		return s;
	}

	public ArrayList<Order> sortListCompletedOrderByCost(ArrayList<Order> s) {
		Collections.sort(s, new Comparator<Order>() {
	        public int compare(Order o1, Order o2) {
	                return o1.getOrderCost().compareTo(o2.getOrderCost());
	        }
		});
		return s;
	}
}


