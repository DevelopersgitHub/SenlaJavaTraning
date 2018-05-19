package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class BookSortName extends ActionView {

	public BookSortName(){
		super("", "Show sorting of books by name");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortNameBook();;
	}

}
