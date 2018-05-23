package com.senla.ui.menu;

public class MenuItem {
	
	protected String name;
	protected IAction action;
	private Menu menu;
	
	public MenuItem(String name, IAction action, Menu menu) {
		this.name = name;
		this.action = action;
		this.menu = menu;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public IAction getAction() {
		return action;
	}
	
	public void setAction(IAction action) {
		this.action = action;
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
