package com.senla.ui;

import com.senla.ui.api.MenuView;

public class MainMenuView {

    public static void main(String[] args) {
        
        MenuView menuView = new MenuView("Welcome!", "");
        
        MenuView bookMenu = new MenuView("Books Menu", "Books Menu");
    	
    	bookMenu.addMenuItem(new BookList());
    	bookMenu.addMenuItem(new BookSortName());
    	bookMenu.addMenuItem(new BookSortDatePublic());
    	bookMenu.addMenuItem(new BookSortCost());
    	bookMenu.addMenuItem(new BookSortPresence());
    	bookMenu.addMenuItem(new ListStaleBooks());
    	bookMenu.addMenuItem(new ViewBookDescription());
    	
    	menuView.addMenuItem(bookMenu);	
    	
    	MenuView staleBooksMenu = new MenuView("Stale of books", "Stale of books");
    	bookMenu.addMenuItem(staleBooksMenu);	
    	staleBooksMenu.addMenuItem(new ListStaleBooks());
    	staleBooksMenu.addMenuItem(new SortListStaleBooksByDate());
    	staleBooksMenu.addMenuItem(new SortListStaleBooksByCost());
    	
    	MenuView subBookMenu = new MenuView("Count of requests", "Count of requests");
    	subBookMenu.addMenuItem(new BookCountRequests());
    	subBookMenu.addMenuItem(new SortBookRequestsByCount());
    	subBookMenu.addMenuItem(new SortBookRequestsByAlph());
    	bookMenu.addMenuItem(subBookMenu);
    	
    	MenuView orderMenu = new MenuView("Ordes Menu", "Orders Menu");
    	
    	orderMenu.addMenuItem(new OrderList());
    	orderMenu.addMenuItem(new OrderSortDateExecution());
    	orderMenu.addMenuItem(new OrderSortCost());
    	orderMenu.addMenuItem(new OrderSortStatus());
    	orderMenu.addMenuItem(new ViewOrderDetails());
    	
    	MenuView completedOrdersMenu = new MenuView("Completed of orders", "Completed of orders");
    	
    	orderMenu.addMenuItem(completedOrdersMenu);
    	
    	completedOrdersMenu.addMenuItem(new ListCompletedOrders());
    	completedOrdersMenu.addMenuItem(new CompletedOrders());
    	completedOrdersMenu.addMenuItem(new SortCompletedOrdersByDate());
    	completedOrdersMenu.addMenuItem(new SortCompletedOrdersByCost());
    	completedOrdersMenu.addMenuItem(new OrdersTotalPrice());
    	
    	menuView.addMenuItem(orderMenu);	
    	
    	MenuView clientMenu = new MenuView("Clients Menu", "Clients Menu");
    	clientMenu.addMenuItem(new ClientMenu());
    	
    	menuView.addMenuItem(clientMenu);
    	
        menuView.display();
    	
    }
}
