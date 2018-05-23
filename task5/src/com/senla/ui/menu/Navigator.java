package com.senla.ui.menu;

import java.util.List;
import java.util.Scanner;


/**
 * used to navigate the menu
 * @version 2.0
 *
 */

public class Navigator {
	
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * gets the name of menu and prints the menu
	 * @param menu for print
	 */
	public static void printMenu(Menu menu) {
		
		List<MenuItem> list = menu.getMenuItems();
		MenuItem[] arr = list.toArray(new MenuItem[list.size()]);
		
		System.out.println(menu.getName());
		for(int i = 0; i < arr.length; i++) {
			System.out.println((i+1) + ") " + arr[i].getName());
		}
	}

	/**
	 * used to launch the main menu, get items from the list, execute one application logic and allow navigation
	 * @param buildMenu, accepts  the original menu
	 * @param index used for the level in the menu.
	 * @see Builder
	 */
	public void start(Menu buildMenu) {
		while(buildMenu != null) {
			Navigator.printMenu(buildMenu);
			int index = getInt("\nPlease enter a number to continue: ");
			MenuItem menuItem = buildMenu.getMenuItems().get(index-1);
			menuItem.getAction().execute();
			System.out.println("\n");
			buildMenu = menuItem.getMenu();
		}
	}
	
	/**
	 * @param mes, message for the user
	 * @return number that the user entered.
	 */
	public static int getInt(String message) {
		int number = 0;
		boolean append = true;
		while(append) {
			System.out.print(message);
			String str = scanner.next();
			number = Integer.parseInt(str);
			append = false;
		}
		return number;
	}

}
