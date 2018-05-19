package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class SortListStaleBooksByCost extends ActionView {

	public SortListStaleBooksByCost(){
		super("", "Sorting of list stale books by cost");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortListCompletedOrderByCost();
	}


}
