package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class BookList extends ActionView {
	
	public BookList(){
		super("", "Show books");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showBooks();
	}
 }
	
