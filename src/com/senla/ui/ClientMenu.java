package com.senla.ui;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.api.ActionView;

public class ClientMenu extends ActionView {
	
	public ClientMenu(){
		super("", "Show Clients");
	}
	
	@Override
	public void executeCustomAction() {
		IController controller = new Controller();
		controller.showClients();
	}
}
