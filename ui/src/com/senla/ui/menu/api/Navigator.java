package com.senla.ui.menu.api;

import java.util.List;

import com.senla.ui.menu.util.ScannerHelper;

/**
 * used to navigate the menu
 * @version 2.0
 *
 */

public class Navigator {
	ScannerHelper scannerHelper = new ScannerHelper();
	
	/**
	 * gets the name of menu and prints the menu
	 * @param menu for print
	 */
	public void printMenu(Menu menu) {
		List<MenuItem> list = menu.getMenuItems();
		MenuItem[] arr = list.toArray(new MenuItem[list.size()]);
		System.out.println(menu.getName());
		for(int i = 0; i < arr.length; i++) {
			System.out.println((i+1) + ") " + arr[i].getName());
		}
	}

	/**
	 * used to launch the main menu, get items from the list, execute one application logic and allow navigation
	 * @param buildMenu, accepts the original menu
	 * @param index used for the level in the menu
	 * @see Builder
	 */
	public void start(Menu buildMenu) {
		while(buildMenu != null) {
			printMenu(buildMenu);
			int index;
			index = this.scannerHelper.getInt("\nPlease enter a number to continue: ");
			MenuItem menuItem = buildMenu.getMenuItems().get(index-1);
			if(menuItem.getAction() != null) {
				menuItem.getAction().execute();
			}
			System.out.println("\n");
			buildMenu = menuItem.getMenu();
		}
	}
}
