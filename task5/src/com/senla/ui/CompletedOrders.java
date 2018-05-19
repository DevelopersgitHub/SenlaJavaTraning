package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class CompletedOrders extends ActionView {
	
	public CompletedOrders(){
		super("", "Show count completed orders for a period of time");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showCountCompletedOrders();
	}

}
