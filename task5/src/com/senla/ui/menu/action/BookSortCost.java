package com.senla.ui.menu.action;

import com.senla.backend.controller.Controller;
import com.senla.backend.controller.IController;
import com.senla.ui.menu.IAction;

public class BookSortCost implements IAction {

	@Override
	public void execute() {
		IController controller = new Controller();
		controller.showSortCostBook();
	}

}
