package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class OrderSortDateExecution extends ActionView {

	public OrderSortDateExecution(){
		super("", "Show sorting of orders by date execution");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortDateExecutionOrder();
	}

}
