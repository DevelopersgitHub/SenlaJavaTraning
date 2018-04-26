package com.senla.training.model;

import java.util.ArrayList;
import java.util.List;

/**
*List of order for the book
*/

public class Order {
	private Long orderID;
	private Customer customerID;
	private String dateExecution;
	private String state;
	public Long cost = 0L;
	private List<Book> objectArray = new ArrayList<Book>();
	
	public Order(){}
	
	public Order(Long orderID,String dateExecution,Long cost,String state){
		this.orderID = orderID;
		this.dateExecution = dateExecution;
		this.cost = cost;
		this.state = state;
	}
	
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public Long getOrderID() {
		return orderID;
	}
	
	public void setDateExecution(String dateExecution) {
		this.dateExecution = dateExecution;
	}
	public String getDateExecution() {
		return dateExecution;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	
	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Customer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public String toString() {
		return "Order [OrderID=" + orderID + ", DateExecution=" + dateExecution + ", Cost= "+ cost + ", State=" + state + "]";
	}
	
	public void addOrder(Book object){
	        objectArray.add(object);
	}
	public void removeOrder(Book object) {
			objectArray.remove(object);
	}
	    
	public void printChecks(){
		for(int i = 0; i < objectArray.size(); i++){
	        Book object = objectArray.get(i);
	        String name = object.getNameBook();
	        System.out.println((i+1) + ") " + name + "\nPrice: " + cost);
	        cost += object.getCost();
	        }
		System.out.println("\nTotal: " + cost);
	}

	public void printSumOneOrder(Order[] orderAll){
		for(int i = 0; i < orderAll.length; i++){
			cost = orderAll[i].getCost();
			System.out.println("\nTotal: " + cost);
		}
	}
	
	public void printSumAllOrder(Order[] orderAll){
		for(int i = 0; i < orderAll.length; i++){
			cost += orderAll[i].getCost();
		}
		System.out.println("\nTotal: " + cost);
	}

	public int printCount(Order[] orderAll){
			int count = 0;
			for(int i = 0; i < orderAll.length; i++){
				String str = orderAll[i].getState();
				if(str.equals("Completed")){
					count = orderAll.length;
				}else {
					count = orderAll.length-1;
				}
			}
			return count;
		}
	}

