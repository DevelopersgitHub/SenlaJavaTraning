package com.senla.model;


public class Book {
	private Long id;
	private String name;
	private java.util.Date date;
	private Double cost;
	private Boolean presence;
	private String description;
	
	public Book() {
	}
	
	public Book(Long id,String name,java.util.Date date2,Double cost,Boolean presence,String bookDescription) {
		this.id = id;
		this.name = name;
		this.date = date2;
		this.cost = cost;
		this.presence = presence;
		this.description = bookDescription;
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

