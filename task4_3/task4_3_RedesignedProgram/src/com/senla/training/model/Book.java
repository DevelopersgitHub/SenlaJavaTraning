package com.senla.training.model;

import java.util.ArrayList;
import java.util.List;

public class Book{
	private Long ID;
	private String nameBook;
	private String datePublic;
	private Long cost;
	private Long presence;
	private String description;
	private BookGenre genre;
	private List<Book> objectArray = new ArrayList<Book>();
	
	public Book(){}
	
	public Book (Long id,String nBook,String dPublic,Long cost,Long pres, String description){
		this.ID = id;
		this.nameBook = nBook;
		this.datePublic = dPublic;
		this.cost = cost;
		this.presence = pres;
		this.description = description;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long id) {
		this.ID = id;
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
	
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Long getCost() {
		return cost;
	}
	
	public void setPresence(Long pres) {
		this.presence = pres;
	}
	public Long getPresence() {
		return presence;
	}
	
	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Book [ID=" + ID + ", name=" + nameBook + ", Date Public=" + datePublic + ", cost=" + cost + ", presence=" + presence + ", description= " + description + "]";
	}
	
	public void addBook(Book object){
        objectArray.add(object);  
	}
	/*
	 * method returns all orders that contain this book 
	 * for a list of book requests
	 */

	public int countRequest(Book[] persons, String str) {
		int count = 0;
		for(int i = 0; i < persons.length; i++){
			String str1 = persons[i].getNameBook();
			if(str.equals(str1)){
			count++;
			}
		}
		return count;
		
	}
}
