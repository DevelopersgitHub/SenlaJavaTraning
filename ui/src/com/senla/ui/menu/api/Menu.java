package com.senla.ui.menu.api;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private String name;
	private List<MenuItem> menuItems;


	public Menu(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
	}
	

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}
	
	public void removeMenuItem(MenuItem menuItem) {
		menuItems.remove(menuItem);
	}
	
	public String getName() {
		return name;
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
