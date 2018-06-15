package com.senla.ui.menu.util;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.ui.menu.api.Navigator;

public class ScannerHelper {
	private static final Logger LOGGER = LogManager.getLogger(Navigator.class.getSimpleName());
	private static Scanner scanner = new Scanner(System.in);
	/**
	 * @param message, message for the user
	 * @return number that the user entered
	 */
	public int getInt(String message) {
		int number = 0;
		try {	
			while(true) {
				System.out.print(message);
				String str = scanner.next();
				number = Integer.parseInt(str);
				break;
			}
		} catch(Exception e) {
			LOGGER.error(e.getMessage(),  e);
		}
		return number;
	}
}
