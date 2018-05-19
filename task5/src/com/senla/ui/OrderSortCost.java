package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class OrderSortCost extends ActionView {

	public OrderSortCost(){
		super("", "Show sorting of orders by cost");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortCostOrder();
	}

}
