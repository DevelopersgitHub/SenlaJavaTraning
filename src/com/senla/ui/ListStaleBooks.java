package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class ListStaleBooks extends ActionView {

	public ListStaleBooks(){
		super("", "List of stale books");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.orderListStaleBook();
	}

}
