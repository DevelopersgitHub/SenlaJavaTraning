package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class SortCompletedOrdersByDate extends ActionView {

	public SortCompletedOrdersByDate(){
		super("", "Show sort of completed orders by date");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortListCompletedOrderByDate();
	}

}
