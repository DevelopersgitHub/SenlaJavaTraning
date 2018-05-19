package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class BookSortDatePublic extends ActionView {

	public BookSortDatePublic(){
		super("", "Show sorting of books by date public");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showSortDatePublicBook();
	}

}
