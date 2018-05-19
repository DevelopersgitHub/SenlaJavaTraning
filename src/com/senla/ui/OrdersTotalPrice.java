package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class OrdersTotalPrice extends ActionView {

	public OrdersTotalPrice(){
		super("", "Total price of completed orders");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSumOrders();
	}

}
