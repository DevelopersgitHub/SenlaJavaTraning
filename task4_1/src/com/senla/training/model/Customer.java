package com.senla.training.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
	
	private IdCard iCard; 
	private List<Order> objectArray = new ArrayList<Order>();
	
	public Customer(Long ID, String login,String password) {
		super(ID, login, password);
		
	}
	
	public void setIdCard(IdCard c) {
		iCard = c;
	}
	public IdCard getIdCard() {
		return iCard;
	}
	
	
	public void printChecks(){
		for(int i = 0; i < objectArray.size(); i++){
	        Order object = (Order) objectArray.get(i);
	        Long orderID = object.getOrderID();
	        Long price = object.getCost();
	        System.out.println((i+1) + ") " + orderID + "\nPrice: " + price);
	       	}
	}
}