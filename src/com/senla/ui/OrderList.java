package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class OrderList extends ActionView {

	public OrderList(){
		super("", "Show orders");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showOrders();
	}

}
