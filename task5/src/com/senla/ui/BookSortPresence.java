package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class BookSortPresence extends ActionView {

	public BookSortPresence(){
		super("", "Show sorting of books by status");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortPresenceBook();
	}

}
