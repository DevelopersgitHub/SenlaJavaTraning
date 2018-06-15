package com.senla.ui.menu.controller;

import com.senla.ui.menu.api.Builder;
import com.senla.ui.menu.api.Navigator;

/**
 * used to build and navigate menus
 * @see Builder, Navigator
 * @version 2.0
 */
public class MenuController {
	/**
	 * builder for building menus, navigator for navigating through menus and console input
	 */
	public static void main(String[] args) {
		Builder builder = new Builder();
		Navigator navigator = new Navigator();
		run(builder, navigator);
	
	}
	/**
	 * builder collects the menu
	 * navigator takes the menu and allows the user to execute the business logic of the application
	 * @param builder
	 * @param navigator
	 */
	public static void run(Builder builder, Navigator navigator) {
		navigator.start(builder.buildMenu());
	}
}
