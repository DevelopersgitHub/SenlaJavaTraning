package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class SortBookRequestsByAlph extends ActionView {

	public SortBookRequestsByAlph(){
		super("", "Sorting of requests by alph");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortAlphRequestBooks();
	}

}
