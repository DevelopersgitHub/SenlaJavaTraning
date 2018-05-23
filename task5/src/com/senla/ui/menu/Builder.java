package com.senla.ui.menu;

import com.senla.ui.menu.action.*;

/**
 * Used to build the main menu
 * @see Menu, MenuItem
 * @version 2.0
 */

public class Builder {
	
	
	/**
	 * creating a menu
	 * @see constructors in classes Main, MenuItem
	 * 
	 * @return main menu
	 */
	
	public Menu buildMenu() {
		Menu main = new Menu("Welcome!");
		
		Menu book = new Menu("Books");
		Menu order = new Menu("Orders");
		Menu client = new Menu("Clients");
		
		main.addMenuItem(new MenuItem("Books Menu", new EmptyAction(), book));
		main.addMenuItem(new MenuItem("Orders Menu", new EmptyAction(), order));
		main.addMenuItem(new MenuItem("Clients Menu", new EmptyAction(), client));
		main.addMenuItem(new MenuItem("Quit",  new EmptyAction(), null));
		
		Menu staleBooks = new Menu("Stale of books");
		Menu countRequest = new Menu("Count of requests");
		
		book.addMenuItem(new MenuItem("Show Books", new BookList(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by name", new BookSortName(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by date of public", new BookSortDatePublic(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by presence", new BookSortPresence(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by cost", new BookSortCost(), book));
		book.addMenuItem(new MenuItem("List of stale books", new EmptyAction(), staleBooks));
		book.addMenuItem(new MenuItem("Show the description of the book", new ViewBookDescription(), book));
		book.addMenuItem(new MenuItem("Count of book requests", new EmptyAction(), countRequest));
		book.addMenuItem(new MenuItem("Back",  new EmptyAction(), main));
		
		staleBooks.addMenuItem(new MenuItem("List of stale books", new ListStaleBooks(), staleBooks));
		staleBooks.addMenuItem(new MenuItem("Sorting of list stale books by date", new SortListStaleBooksByDate(), staleBooks));
		staleBooks.addMenuItem(new MenuItem("Sorting of list stale books by cost", new SortListStaleBooksByCost(), staleBooks));
		staleBooks.addMenuItem(new MenuItem("Back",  new EmptyAction(), book));
		
		countRequest.addMenuItem(new MenuItem("Count of book requests", new BookCountRequests(), countRequest));
		countRequest.addMenuItem(new MenuItem("Sorting of requests by count", new SortBookRequestsByCount(), countRequest));
		countRequest.addMenuItem(new MenuItem("Sorting of requests by alph", new SortBookRequestsByAlph(), countRequest));
		countRequest.addMenuItem(new MenuItem("Back",  new EmptyAction(), book));
		
		Menu completedOrdersMenu = new Menu("Completed of orders");
		
		order.addMenuItem(new MenuItem("Show orders", new OrderList(), order));
		order.addMenuItem(new MenuItem("Show sorting of orders by date execution", new OrderSortDateExecution(), order));
		order.addMenuItem(new MenuItem("Show sorting of orders by cost", new OrderSortCost(), order));
		order.addMenuItem(new MenuItem("Show sorting of orders by status", new OrderSortStatus(), order));
		order.addMenuItem(new MenuItem("Completed of orders", new EmptyAction(), completedOrdersMenu));
		order.addMenuItem(new MenuItem("Show order details", new ViewOrderDetails(), order));
		order.addMenuItem(new MenuItem("Back",  new EmptyAction(), main));
		
		completedOrdersMenu.addMenuItem(new MenuItem("Show list completed orders for a period of time", new ListCompletedOrders(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Show count completed orders for a period of time", new CompletedOrders(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Show sort of completed orders by date", new SortCompletedOrdersByDate(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Show sort of completed orders by cost", new SortCompletedOrdersByCost(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Total price of completed orders", new OrdersTotalPrice(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Back",  new EmptyAction(), order));
		
		client.addMenuItem(new MenuItem("Show clients", new ClientList(), client));
		client.addMenuItem(new MenuItem("Back",  new EmptyAction(), main));
		
		return main;
	}
	
}







