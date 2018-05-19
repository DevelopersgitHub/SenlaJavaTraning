package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class SortListStaleBooksByDate extends ActionView {

	public SortListStaleBooksByDate(){
		super("", "Sorting of list stale books by date");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortListCompletedOrderByDate();
	}

}
