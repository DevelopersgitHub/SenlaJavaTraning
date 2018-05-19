package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class OrderSortStatus extends ActionView {

	public OrderSortStatus(){
		super("", "Show sorting of orders by status");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortStatusOrder();
	}

}
