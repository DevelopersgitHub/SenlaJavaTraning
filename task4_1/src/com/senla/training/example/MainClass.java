package com.senla.training.example;


import java.util.ArrayList;

import com.senla.training.fileutil.BookFileUtil;
import com.senla.training.fileutil.FileUtil;
import com.senla.training.fileutil.FileUtilOrder;
import com.senla.training.fileutil.OrderFileUtil;
import com.senla.training.model.*;

public class MainClass {
	public static ArrayList<Book> booksDel = new ArrayList<Book>();
	public static ArrayList<Order> OrderDel = new ArrayList<Order>();
	public static void main(String s[]) throws Exception{
		
	
		final FileUtil<Book> util = new BookFileUtil();
		final Book[] readedValues = util.readFromFile();
		
		/**
		 * Reading books from a file
		 */
		
		System.out.println("List of books: ");
		for (int i = 0; i < readedValues.length; i++ ){
			System.out.println(readedValues[i]);
		}
		
		/**
		 * Sorting books
		 */
		
		Sorting sort = new Sorting();
		sort.sortNameBook(readedValues);
		sort.sortDatePublic(readedValues);
		sort.sortCost(readedValues);
		sort.sortPresense(readedValues);
		
		System.out.println("\n----------------");
		
		Customer customer = new Customer(1L, "Michael","Senla");
		
		
		/**
		 * Add to orders
		 */
		
		
		System.out.println("Client with id: " + customer.getUserID());
		System.out.println("----------------\n");
		Order order = new Order();
		order.setOrderID(1L);
		order.setState("Completed");
		Book book1 = new Book(1L, "The Picture of Dorian Gray", "21/08/2011", 1023L,1L,"description");
		order.addOrder(book1);
		Book book2 = new Book(2L, "Divergent","19/05/2010", 764L,0L,"description");
		order.addOrder(book2);
		Book book3 = new Book(3L, "Twilight","20/07/2009", 1023L,1L,"description");
		order.addOrder(book3);
		
        
        Order order2 = new Order();
        order2.setOrderID(2L);
        order2.setState("Completed");
		Book book4 = new Book(1L, "Alchemist", "21/08/2011", 1023L,1L,"description");
		order2.addOrder(book4);
		Book book5 = new Book(2L, "Divergent","19/05/2010", 456L,0L,"description");
		order2.addOrder(book5);
		Book book6 = new Book(3L, "Twilight","20/07/2009", 247L,1L,"description");
		order2.addOrder(book6);
		
       
		
        Order order3 = new Order();
		order3.setOrderID(3L);
		order3.setState("Completed");
		Book book7 = new Book(1L, "Pride and Prejudice", "21/08/2011", 1023L,1L,"description");
		order3.addOrder(book7);
		Book book8 = new Book(2L, "Great Gatsby","19/05/2010", 1964L,0L,"description");
		order3.addOrder(book8);
		Book book9 = new Book(3L, "Alchemist","20/07/2009", 1224L,1L,"description");
		order3.addOrder(book9);
		
        

		final FileUtilOrder<Order> util2 = new OrderFileUtil();
		final Order[] readedValues1 = util2.readFromFile();
		
        for (int i = 0; i < readedValues1.length; i++ ){
			System.out.println(readedValues1[i]);
		} 
        
        System.out.println("\nView order details\n");
        System.out.println("---------------------");
        System.out.println("\nOrder number: " + order.getOrderID());
        order.printChecks();
        System.out.println("---------------------");
        System.out.println("\nOrder number: " + order2.getOrderID());
		order2.printChecks();
        System.out.println("---------------------");
		System.out.println("\nOrder number: " + order3.getOrderID());
		order3.printChecks();
        System.out.println("---------------------");
        
       
       /*
        * Sorting orders
        */
        
		sort.sortDateExecution(readedValues1);
		sort.sortCostOrder(readedValues1);
		sort.sortState(readedValues1);
		
		
		
		 /*
         * Cancel the order
         */
		System.out.println("\n-----------\n");
		order3.removeOrder(book7);
		System.out.println("\nOrder 3 canceled\n");
		
		
		/*
		 * Description of the book
		 * The description is contained in the .txt file
		 */
		System.out.println("\n\n---------------------\n");
		System.out.println("Description of the book: \n");
		for (int i = 0; i < readedValues.length; i++ ){
			if(readedValues[i].getID() == 1)
			System.out.println(readedValues[i].getDescription());
		}
		
		
		/*
		 * List of completed orders
		 */
		
		for (int i = 0; i < readedValues1.length; i++ ){
			if(readedValues1[i].getState() == "Completed") {
				System.out.println(readedValues1[i].getOrderID());
			}
		}
		sort.sortDateExecution(readedValues1);
		sort.sortCostOrder(readedValues1);
		
		Order[] orderAll = new Order[]{ order, order2, order3};
		 
		 
		 /*
		  * Add book
		  */
		 
		Book books1 = new Book();
		Book books10 = new Book(1124L,"Island on the edge of everything","10/10/2018",983L,1L,"Popular book");
		books1.addBook(books10);
		System.out.println("\n\n---------------------\n");
		System.out.println("A new book: " + books10.getNameBook() + " " + books10.getCost());
		 
		System.out.println("\n\n---------------------\n");
		System.out.println("\nAmount earned from one order\n");
		Order orderSum1 = new Order();
		orderSum1.printSumOneOrder(orderAll);
		
		System.out.println("\n\n---------------------\n");
		System.out.println("Amount of funds earned\n");
		Order orderSum = new Order();
		orderSum.printSumAllOrder(orderAll);
		 
		System.out.println("\n\n---------------------\n");
		System.out.println("Number of completed orders\n");
		Order orderCount = new Order();
		int n = orderCount.printCount(orderAll);
		System.out.println(n);
		 
		 
		 /*
		  * Write off the book from the warehouse
		  */

		 System.out.println("\n\n---------------------\n");
		 
		 Book bookDelete = new Book(1L, "Pride and Prejudice", "21/08/2011", 1023L,1L,"description");
		 booksDel.add(bookDelete);
		 booksDel.remove(0);
		 System.out.println("Book: "+ bookDelete.getNameBook() + " removed\n");
		 for (Book s1: booksDel) {
		     System.out.print(s1);
		}
		
		 
		 /*
		  * The list of requests for the book "Alchemist",
		  *  is based on the method in the book class and 
		  *  is an estimate of the orders where the book is contained.
		  */
		 
		Book[] persons = new Book[]{ book1, book2, book3,book4, book5, book6,book7, book8, book9};
		System.out.println("\n\n---------------------\n");
	 	Book orderRequest = new Book();
	 	String str = "Alchemist";
	 	String str1 = "Great Gatsby";
		int n1 = orderRequest.countRequest(persons,str);
		int n2 = orderRequest.countRequest(persons,str1);
		System.out.println("Count of requests for second of book: " + n2);
		System.out.println("Count of requests for first of book: " + n1);
		
		
		
		/**
		 * Sorting requests
		 */
		sort.sortCountRequest(persons);
	}
}

	
