package com.senla.ui.menu.action;

import com.senla.ui.controller.Controller;
import com.senla.ui.menu.api.IAction;

public class SaveBook implements IAction {

	@Override
	public void execute() {
		Controller.getInstance().saveBook();
	}

}
