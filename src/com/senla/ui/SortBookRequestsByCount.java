package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class SortBookRequestsByCount extends ActionView {

	public SortBookRequestsByCount(){
		super("", "Sorting of requests by count");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortCountRequestBooks();
	}

}
