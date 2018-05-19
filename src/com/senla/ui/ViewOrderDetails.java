package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class ViewOrderDetails extends ActionView {

	public ViewOrderDetails(){
		super("", "Show order details");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showOrderDetails();
	}

}
