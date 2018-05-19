package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class BookCountRequests extends ActionView {

	public BookCountRequests(){
		super("", "Count of book requests");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showCountRequestBooks();
	}

}
