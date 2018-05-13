package com.senla.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private Long id;
	private String name;
	List<Order> orders;
	
	public Client() {
		orders = new ArrayList<Order>();
	}
	public Client(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getClientID() {
		return id;
	}
	public void setClientID(Long iD) {
		this.id = iD;
	}
	public String getClientName() {
		return name;
	}
	public void setClientName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Client[id=" + id + ", Name=" + name + "]";
	}
}
