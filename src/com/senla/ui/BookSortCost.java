package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class BookSortCost extends ActionView {

	public BookSortCost(){
		super("", "Show sorting of books by cost");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortCostOrder();
	}

}
