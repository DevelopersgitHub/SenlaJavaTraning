package com.senla.backend.controller;

import com.senla.annotation.ConfigAnnotation;
import com.senla.annotation.ConfigProperty;
import com.senla.backend.service.IShop;
import com.senla.backend.service.Shop;

public class ConfigMain {
	
	@ConfigProperty(propertyName = "month", type = Integer.class)
	private static int count;
	
	@ConfigProperty(propertyName = "completedRequest", type = Boolean.class)
	private static boolean powerOrders;
	
	public ConfigMain() {
		ConfigAnnotation.loadAnnotation(this);
	}
	
	public static void main(String[] args) {
		ConfigMain configMain = new ConfigMain();
		IShop shop = new Shop();
		shop.countMonthWait(count);
		shop.powerOrdersCompeled(powerOrders);
	}
}
