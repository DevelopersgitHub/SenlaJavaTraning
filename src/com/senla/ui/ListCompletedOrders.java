package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class ListCompletedOrders extends ActionView {

	public ListCompletedOrders(){
		super("", "Show list completed orders for a period of time");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showListCompletedOrders();
	}

}
