package com.senla.training.example;


public class Book{
	private Long id;
	private String nameBook;
	private String datePublic;
	private double cost;
	private Long presence;
	Book (Long id,String nBook,String dPublic,double cost,Long pres){
		this.id = id;
		this.nameBook = nBook;
		this.datePublic = dPublic;
		this.cost = cost;
		this.presence = pres;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setNameBook(String nBook) {
		this.nameBook = nBook;
	}
	public String getNameBook() {
		return nameBook;
	}
	
	public void setDatePublic(String dPublic) {
		this.datePublic = dPublic;
	}
	public String getDatePublic() {
		return datePublic;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCost() {
		return cost;
	}
	
	public void setPresence(Long pres) {
		this.presence = pres;
	}
	public Long getPresence() {
		return presence;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + nameBook + ", Date Public=" + datePublic + ", cost=" + cost + ", presence=" + presence + "]";
	}
}
