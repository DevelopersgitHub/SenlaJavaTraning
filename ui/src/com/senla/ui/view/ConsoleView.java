package com.senla.ui.view;

import java.util.List;

import com.senla.backend.dto.DTO;
import com.senla.backend.model.Book;
import com.senla.backend.model.Client;
import com.senla.backend.model.Order;

public class ConsoleView implements IView {
	

	public void addBook(Book book) {
		System.out.println("\nAdd new book\n---------------------\n");
		System.out.println(
				book.getBookID() + "; " + 
				book.getBookName() + "; " + 
				book.getBookDatePublic() + "; " + 
				book.getBookCost() + "; " + 
				book.getBookPresence() + "; " +
				book.getBookDescription()
		);
	}
	
	public void getBook(Book book) {
		System.out.println("\nGet book\n---------------------\n");
		System.out.println(
				book.getBookID() + "; " + 
				book.getBookName() + "; " + 
				book.getBookDatePublic() + "; " + 
				book.getBookCost() + "; " + 
				book.getBookPresence() + "; " +
				book.getBookDescription()
		);
	}

	public void getAllBook(List<Book> book) {
		System.out.println("\nGet all book\n---------------------\n");
		for(Book books : book) {
			System.out.println(
					books.getBookID() + "; " + 
					books.getBookName() + "; " + 
					books.getBookDatePublic() + "; " + 
					books.getBookCost() + "; " + 
					books.getBookPresence() + "; " +
					books.getBookDescription()
			);
		}
	}

	public void updateBook(Book books) {
		System.out.println("\nUpdate list of books\n");
		System.out.println("Add of new books\n---------------------\n");
		System.out.println(
					books.getBookID() + "; " + 
					books.getBookName() + "; " + 
					books.getBookDatePublic() + "; " + 
					books.getBookCost() + "; " + 
					books.getBookPresence() + "; " +
					books.getBookDescription()
			);
		}
	

	public void removeBook(Book books) {
		System.out.println("\nUpdate list of books\n");
		System.out.println("Removed of book\n---------------------\n");
		System.out.println(
					books.getBookID() + "; " + 
					books.getBookName() + "; " + 
					books.getBookDatePublic() + "; " + 
					books.getBookCost() + "; " + 
					books.getBookPresence() + "; " +
					books.getBookDescription()
			);
	}
	

	public void addOrder(Order order) {
		System.out.println("\nAdd new order\n---------------------\n");
		System.out.println(
				order.getID() + "; " + 
				order.getOrderContent() + "; " + 
				order.getOrderCost() + "; " + 
				order.getOrderExecutionDate() + "; " + 
				order.getOrderStatus()
		);
		
	}

	public void getOrder(Order order) {
		System.out.println("\nGet order\n---------------------\n");
		System.out.println(
				order.getID() + "; " + 
				order.getOrderContent() + "; " + 
				order.getOrderCost() + "; " + 
				order.getOrderExecutionDate() + "; " + 
				order.getOrderStatus()
		);
	}

	public void getAllOrder(List<Order> orders) {
		System.out.println("\nGet all order\n---------------------\n");
		for(Order order : orders) {
			System.out.println(
					order.getID() + "; " + 
					order.getOrderContent() + "; " + 
					order.getOrderCost() + "; " + 
					order.getOrderExecutionDate() + "; " + 
					order.getOrderStatus()
			);
		}
	}

	public void updateOrder(Order orders) {
		System.out.println("\nUpdate list of orders\n");
		System.out.println("Add of new orders\n---------------------\n");
		System.out.println(
				orders.getID() + "; " + 
				orders.getOrderContent() + "; " + 
				orders.getOrderCost() + "; " + 
				orders.getOrderExecutionDate() + "; " + 
				orders.getOrderStatus()
			);
	}

	public void removeOrder(Long id) {
		System.out.println("Removed of order: " + id + "\n---------------------\n");
	}
	
	public void addClient(Client client) {
		System.out.println("\nAdd new client\n---------------------\n");
		System.out.println(
				client.getClientID() + "; " + 
				client.getClientName()
		);
		
	}
	
	public void getClient(Client clients) {
		System.out.println("\nGet client\n---------------------\n");
		System.out.println(
				clients.getClientID() + "; " + 
				clients.getClientName()
		);
	}

	public void getAllClient(List<Client> clients) {
		System.out.println("\nGet all clients\n---------------------\n");
		for(Client client : clients) {
			System.out.println(
				client.getClientID() + "; " + 
				client.getClientName()
			);
		}
	}

	public void updateClient(Client clients) {
		System.out.println("\nUpdate list of clients\n");
		System.out.println("Add of new clients\n---------------------\n");
		System.out.println(
				clients.getClientID() + "; " + 
				clients.getClientName()
			);
	}

	public void removeClient(Client client) {
		System.out.println("\nUpdate list of clients\n");
		System.out.println("Removed of client\n---------------------\n");
		System.out.println(
				client.getClientID() + "; " + 
				client.getClientName()
			);
	}
	
	public void showBooks(Book[] books) {
		System.out.println("\nList of books\n---------------------\n");
		for(Book bookList : books) {
			System.out.println(bookList);
		}
	}
	
	public void showOrders(Order[] orders) {
		System.out.println("\nList of orders\n---------------------\n");
		for(Order orderList : orders) {
			System.out.println(orderList);
		}
		
	}

	public void showClients(Client[] clients) {
		System.out.println("\nList of clients\n---------------------\n");
		for(Client clientList : clients) {
			System.out.println(clientList);
		}
	}
	
	public void showSortNameBook(Book[] booksSort) {
			System.out.println("\nSort by alphabetically\n---------------------\n");
			for(Book bookSort : booksSort) {
				System.out.println(bookSort.getBookName());
			}
	}
	
	public void showSortDatePublicBook(Book[] booksSort) {
		System.out.println("\nSort by publication date\n---------------------\n");
		for(Book bookSort : booksSort) {
			System.out.println(bookSort.getBookName() + ": " + bookSort.getBookDatePublic());
		}
	}
	
	public void showSortCostBook(Book[] booksSort) {
		System.out.println("\nSort by cost\n---------------------\n");
		for(Book bookSort : booksSort) {
			System.out.println(bookSort.getBookName() + ": " + bookSort.getBookCost());
		}
	}
	
	public void showSortPresenceBook(Book[] booksSort) {
		System.out.println("\nSort by availability of books\n---------------------\n");
		for(Book bookSort : booksSort) {
			System.out.println(bookSort.getBookName() + ": " + bookSort.getBookPresence());
		}
	}

	public void showSortDateExecutionOrder(Order[] orderSort) {
		System.out.println("\n\nSort by execution date\n---------------------\n");
		for(Order ordersSort : orderSort) {
			System.out.println("Order ID: " + ordersSort.getID() + ": " + ordersSort.getOrderExecutionDate());
		}
	}

	public void showSortCostOrder(Order[] orderSort) {
		System.out.println("\nSorting by cost\n---------------------\n");
		for(Order ordersSort : orderSort) {
			System.out.println("Order ID: " + ordersSort.getID() + ": " + ordersSort.getOrderCost());
		}
	}

	public void showSortStatusOrder(Order[] orderSort) {
		System.out.println("\nSort by status\n---------------------\n");
		for(Order ordersSort : orderSort) {
			System.out.println("Order ID: " + ordersSort.getID() + ": " + ordersSort.getOrderStatus());
		}	
	}
	
	public void showOrderDetails(String s) {
		System.out.println("\nOrder details\n---------------------\n");
		System.out.println(s);
	}
	public void showBookDescription(String s) {
		System.out.println("\nBook description\n---------------------\n");
		System.out.println(s);
	}

	public void showListCompletedOrders(List<Order> s) {
		System.out.println("\nList of completed orders\n---------------------\n");
		for(Order l : s) {
			System.out.println(l);
		}
	}

	public void showCountCompletedOrders(int count) {
		System.out.println("\nCount of completed orders: " + count);
		System.out.println("\n---------------------\n");
	}
	
	public void showSortListCompletedOrderByDate(List<Order> s) {
		System.out.println("Sort by execution date\n---------------------\n");
		for (Object o : s){
			System.out.println(o);
		}
	}
	public void showSortListCompletedOrderByCost(List<Order> s) {
		System.out.println("\n---------------------\n");
		System.out.println("Sort by cost\n---------------------\n");
		for (Object o : s){
			System.out.println(o);
		}
	}
	
	public void showSumOrders(double sum) {
		System.out.println("\n---------------------\n");
		System.out.println("Amount of funds earned: " + sum);
		System.out.println("\n---------------------\n");
	}
	
	public void showCountRequestBooks(Integer n1, Integer n2, String str, String str1) {
		System.out.println("Count of requests for '" + str + "': " + n1 +  "\n" +
							"Count of requests for '" + str1 + "': " + n2 + "\n---------------------\n");
	}

	public void showSortCountRequestBooks(List<Integer> array) {
		System.out.println("Sorting by count\n");
		for(Object o : array) {
			System.out.println(o);
		}
	}
	
	public void showSortAlphRequestBooks(List<Order> array) {
		System.out.println("\n---------------------\n");
		System.out.println("Sorting by alphabet\n");
		for(Object o : array) {
			System.out.println(o);
		}
	}
	
	public void orderListStaleBook(List<Order> list) {
		System.out.println("\nList of stale books\n---------------------\n");
		for(Order array : list) {
			System.out.println("ID orders: " + array.getID() + " Book: " + array.getOrderContent() + ", Data of execution orders: "+ array.getOrderExecutionDate() + ", Cost of orders: " + array.getOrderCost());
		}
	}
	
	public void showCloneOrder(Order[] orders) {
		System.out.println("\nList of clone orders\n---------------------\n");
		for(Order order : orders) {
			System.out.println(order);
		}
	}
	

	public void loadBook(Book[] book) {
		System.out.println("Loading is complete!\n");
		for(Book books : book) {
		System.out.println(
				books.getBookID() + "; " + 
				books.getBookName() + "; " + 
				books.getBookDatePublic() + "; " + 
				books.getBookCost() + "; " + 
				books.getBookPresence() + "; " +
				books.getBookDescription()
			);
		}
	}

	
	public void loadOrder(Order[] order) {
		System.out.println("Loading is complete!\n");
		for(Order orders : order) {
		System.out.println(
				orders.getID() + "; " + 
				orders.getOrderContent() + "; " + 
				orders.getOrderCost() + "; " + 
				orders.getOrderExecutionDate() + "; " + 
				orders.getOrderStatus()
			);
		}
	}

	
	public void loadClient(Client[] client) {
		System.out.println("Loading is complete!\n");
		for(Client clients : client) {
			System.out.println(
					clients.getClientID() + "; " + 
					clients.getClientName()
			);
		}
	}

	public void saveBook(Book[] book) {
		System.out.println("Recording is complete!");
	}

	public void saveOrder(Order[] order) {
		System.out.println("Recording is complete!");
	}

	public void saveClient(Client[] client) {
		System.out.println("Recording is complete!");
	}


	public void showImport(List<Book> csvFile) {
		System.out.println("\n\nCSVImportUtil\n\n");
		for(Book booksPrint : csvFile) {
			System.out.println(booksPrint);
		}
	}

	public void showExport() {
		System.out.println("\n\nThe data was successfully exported to a CSV file\n\n");
	}

	public void showDeserialization(DTO bookSerial) {
		System.out.println("\n\nSerializationUtil\n\n");
		
		for(Book bookSer : bookSerial.getBooks()) {
			System.out.println(bookSer);
		}
		System.out.println("\n\n");
		for(Order bookSer : bookSerial.getOrders()) {
			System.out.println(bookSer);
		}
		System.out.println("\n\n");
		for(Client bookSer : bookSerial.getClients()) {
			System.out.println(bookSer);
		}
	}
	
	public void showSerialization() {
		System.out.println("\n\nThe data was successfully serialized in temp.out\n\n");
		
	}
}

