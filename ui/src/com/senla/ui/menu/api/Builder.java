package com.senla.ui.menu.api;

import com.senla.ui.menu.action.*;

/**
 * Used to build the main menu
 * @see class Menu, MenuItem
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
		
		Menu read = new Menu("Load data");
		read.addMenuItem(new MenuItem("Read book data", new LoadBook(), read));
		read.addMenuItem(new MenuItem("Read order data", new LoadOrder(), read));
		read.addMenuItem(new MenuItem("Read client data", new LoadClient(), read));
		read.addMenuItem(new MenuItem("Back",null, main));
		
		Menu save = new Menu("Save data");
		save.addMenuItem(new MenuItem("Save book data", new SaveBook(), save));
		save.addMenuItem(new MenuItem("Save order data", new SaveOrder(), save));
		save.addMenuItem(new MenuItem("Save client data", new SaveClient(), save));
		save.addMenuItem(new MenuItem("Back",null, main));
		
		main.addMenuItem(new MenuItem("Deserialization", new Deserialization(), main));
		main.addMenuItem(new MenuItem("Import",new CSVImport(), main));
		main.addMenuItem(new MenuItem("Read data", null, read));
		main.addMenuItem(new MenuItem("Books Menu", null, book));
		main.addMenuItem(new MenuItem("Orders Menu", null, order));
		main.addMenuItem(new MenuItem("Clients Menu",null, client));
		main.addMenuItem(new MenuItem("Save data",null, save));
		main.addMenuItem(new MenuItem("Export",new CSVExport(), main));
		main.addMenuItem(new MenuItem("Serialization", new Serialization(), main));
		main.addMenuItem(new MenuItem("Quit", null, null));
		
		Menu staleBooks = new Menu("Stale of books");
		Menu countRequest = new Menu("Count of requests");
		
		book.addMenuItem(new MenuItem("Show Books", new BookList(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by name", new BookSortName(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by date of public", new BookSortDatePublic(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by presence", new BookSortPresence(), book));
		book.addMenuItem(new MenuItem("Show sorting of books by cost", new BookSortCost(), book));
		book.addMenuItem(new MenuItem("List of stale books", null, staleBooks));
		book.addMenuItem(new MenuItem("Show the description of the book", new ViewBookDescription(), book));
		book.addMenuItem(new MenuItem("Count of book requests", null, countRequest));
		book.addMenuItem(new MenuItem("Back", null, main));
		
		staleBooks.addMenuItem(new MenuItem("List of stale books", new ListStaleBooks(), staleBooks));
		staleBooks.addMenuItem(new MenuItem("Sorting of list stale books by date", new SortListStaleBooksByDate(), staleBooks));
		staleBooks.addMenuItem(new MenuItem("Sorting of list stale books by cost", new SortListStaleBooksByCost(), staleBooks));
		staleBooks.addMenuItem(new MenuItem("Back", null, book));
		
		countRequest.addMenuItem(new MenuItem("Count of book requests", new BookCountRequests(), countRequest));
		countRequest.addMenuItem(new MenuItem("Sorting of requests by count", new SortBookRequestsByCount(), countRequest));
		countRequest.addMenuItem(new MenuItem("Sorting of requests by alph", new SortBookRequestsByAlph(), countRequest));
		countRequest.addMenuItem(new MenuItem("Back", null, book));
		
		Menu completedOrdersMenu = new Menu("Completed of orders");
		
		order.addMenuItem(new MenuItem("Show orders", new OrderList(), order));
		order.addMenuItem(new MenuItem("Show sorting of orders by date execution", new OrderSortDateExecution(), order));
		order.addMenuItem(new MenuItem("Show sorting of orders by cost", new OrderSortCost(), order));
		order.addMenuItem(new MenuItem("Show sorting of orders by status", new OrderSortStatus(), order));
		order.addMenuItem(new MenuItem("Completed of orders", null, completedOrdersMenu));
		order.addMenuItem(new MenuItem("Show order details", new ViewOrderDetails(), order));
		order.addMenuItem(new MenuItem("Orders clone", new OrderClone(), order));
		order.addMenuItem(new MenuItem("Back", null, main));
		
		completedOrdersMenu.addMenuItem(new MenuItem("Show list completed orders for a period of time", new ListCompletedOrders(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Show count completed orders for a period of time", new CompletedOrders(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Show sort of completed orders by date", new SortCompletedOrdersByDate(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Show sort of completed orders by cost", new SortCompletedOrdersByCost(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Total price of completed orders", new OrdersTotalPrice(), completedOrdersMenu));
		completedOrdersMenu.addMenuItem(new MenuItem("Back", null, order));
		
		client.addMenuItem(new MenuItem("Show clients", new ClientList(), client));
		client.addMenuItem(new MenuItem("Back", null, main));
		
		return main;
	}
	
}







