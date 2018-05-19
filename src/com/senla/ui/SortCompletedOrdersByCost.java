package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class SortCompletedOrdersByCost extends ActionView {

	public SortCompletedOrdersByCost(){
		super("", "Show sort of completed orders by cost");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortListCompletedOrderByCost();
	}

}
