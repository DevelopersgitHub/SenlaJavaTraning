package com.senla.training.example;

import java.util.Arrays;
import java.util.Comparator;

import com.senla.training.model.*;

public class Sorting {
	public void sortNameBook(Book[] readedValues) {
		System.out.println("\nSort by alphabetically: \n");
		System.out.println("---------------------");
		
	
		Arrays.sort(readedValues, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getNameBook().compareTo(o2.getNameBook());
		        }
		});
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i].getNameBook());
		}
	}
	
	
	public void sortDatePublic(Book[] readedValues) {
		System.out.println("\nSort by publication date: \n");
		System.out.println("---------------------");
	
		Arrays.sort(readedValues, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getDatePublic().compareTo(o2.getDatePublic());
		        }
		});
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i].getNameBook() +  "\nDate: " + readedValues[i].getDatePublic());
			}
		}
	
	
	public void sortCost(Book[] readedValues) {
		System.out.println("\nSorting by cost: \n");
		System.out.println("---------------------");
		Arrays.sort(readedValues, new Comparator<Book>() {
	        public int compare(Book o1, Book o2) {
	                return o1.getCost().compareTo(o2.getCost());
	        }
		});
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i].getNameBook() + "\nCost: " +  readedValues[i].getCost());
			}	
		}
	
	public void sortPresense(Book[] readedValues) {
		System.out.println("\nSort by availability: \n");
	
		System.out.println("---------------------");
		
	
		Arrays.sort(readedValues, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getPresence().compareTo(o2.getPresence());
		        }
		});
		System.out.println("In stock: \n");
		for (int i = 0; i < readedValues.length; i++ ){
			if(readedValues[i].getPresence() == 1)
			System.out.println(readedValues[i].getNameBook());
			}
		}
	
	
	public void sortDateExecution(Order[] readedValues1) {
		System.out.println("\n\nSort by execution date: \n");
		System.out.println("---------------------");
	
		Arrays.sort(readedValues1, new Comparator<Order>() {
		        public int compare(Order o1, Order o2) {
		                return o1.getDateExecution().compareTo(o2.getDateExecution());
		        }
		});
		for (int i = 0; i < readedValues1.length; i++ ){
			System.out.println("ID Order: " + readedValues1[i].getOrderID() +  "\nDate: " + readedValues1[i].getDateExecution());
			}
		
	}
	
	public void sortCostOrder(Order[] readedValues1) {
		System.out.println("\nSorting by cost: \n");
		System.out.println("---------------------");
		Arrays.sort(readedValues1, new Comparator<Order>() {
	        public int compare(Order o1, Order o2) {
	                return o1.getCost().compareTo(o2.getCost());
	        }
		});
		for (int i = 0; i < readedValues1.length; i++ ){
			System.out.println("ID Order: " + readedValues1[i].getOrderID() + "\nCost: " +  readedValues1[i].getCost());
		}	
	}
	
	
	public void sortState(Order[] readedValues1) {
		System.out.println("\nSort by status: \n");
	
		System.out.println("---------------------");
		
	
		Arrays.sort(readedValues1, new Comparator<Order>() {
		        public int compare(Order o1, Order o2) {
		                return o1.getState().compareTo(o2.getState());
		        }
		});
		for (int i = 0; i < readedValues1.length; i++ ){
			System.out.println("ID Order: " + readedValues1[i].getOrderID() + "\nStatus: " + readedValues1[i].getState());
			}
		}
	
	
	
	public void sortCountRequest(Book[] persons) {
		System.out.println("\nSort by name: \n");
		
		System.out.println("---------------------");
		
	
		Arrays.sort(persons, new Comparator<Book>() {
		        public int compare(Book o1, Book o2) {
		                return o1.getNameBook().compareTo(o2.getNameBook());
		        }
		});
		for (int i = 0; i < persons.length; i++ ){
			System.out.println((i+1) +") " + "ID = " + persons[i].getID() + "; " + persons[i].getNameBook());
			}
		}
		
	}


