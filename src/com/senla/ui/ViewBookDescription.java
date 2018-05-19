package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class ViewBookDescription extends ActionView {

	public ViewBookDescription(){
		super("", "Show the description of the book");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showBookDescription();
	}

}
