package com.senla.backend.model;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = 8490719371619646067L;
	
	private Long id;
	private String name;
	private java.util.Date date;
	private Double cost;
	private Boolean presence;
	private String description;
	
	public Book(Long id,String name, java.util.Date date, Double cost,Boolean presence,String bookDescription) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.cost = cost;
		this.presence = presence;
		this.description = bookDescription;
	}

	public Book() {
	}

	public Long getBookID() {
		return id;
	}
	public void setBookID(Long iD) {
		this.id = iD;
	}
	public String getBookName() {
		return name;
	}
	public void setBookName(String name) {
		this.name = name;
	}
	public java.util.Date getBookDatePublic() {
		return date;
	}
	public void setBookDatePublic(java.util.Date date) {
		this.date = date;
	}
	public Double getBookCost() {
		return cost;
	}
	public void setBookCost(Double cost) {
		this.cost = cost;
	}
	public Boolean getBookPresence() {
		return presence;
	}
	public void setBookPresence(Boolean presence) {
		this.presence = presence;
	} 

	public String getBookDescription() {
		return description;
	}

	public void setBookDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", DatePublic=" + date + ", Cost= " + cost + ", Presence=" + presence + ", Description=" + description + "]";
	}

}

