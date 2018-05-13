package com.senla.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Long id;
	private String orderContent;
	private java.util.Date dateExecution;
	private Double cost;
	private String status;
	List<Client> clients;

	public Order() {
		clients = new ArrayList<Client>();
	}
	public Order(Long id,String orderContent, java.util.Date date, Double cost, String status) {
		this.id = id;
		this.orderContent = orderContent;
		this.dateExecution = date;
		this.cost = cost;
		this.status = status;
	}
	public Long getID() {
		return id;
	}
	public void setID(Long iD) {
		this.id = iD;
	}
	public java.util.Date getOrderExecutionDate() {
		return dateExecution;
	}
	public void setOrderExecutionDate(java.util.Date dateExecution) {
		this.dateExecution = dateExecution;
	}
	public String getOrderStatus() {
		return status;
	}
	public void setOrderStatus(String status) {
		this.status = status;
	}
	public Double getOrderCost() {
		return cost;
	}
	public void setOrderCost(Double cost) {
		this.cost = cost;
	}
	public String getOrderContent() {
		return orderContent;
	}
	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", OrderContent=" + orderContent + ", DateExecution=" + dateExecution + ", Cost= " + cost + ", Status=" + status + "]";
	}
	
}
