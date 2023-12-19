package com.ecommerce.inventory.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryTest {
	
Inventory inventory;
	
	@BeforeEach
	public void setUpItem() {
		inventory = new Inventory();
		inventory.setAvailableQuantity(100);
		inventory.setCurrentOrderDate(LocalDate.now());
		inventory.setCurrentThresholdDate(LocalDate.now());
		inventory.setItemId(1);
		inventory.setNoStockValue(10);
		inventory.setPreviousOrderDate(LocalDate.now());
		inventory.setPreviousOrderQuantity(70);
		inventory.setPreviousThresoldDate(LocalDate.now());
		inventory.setProbableIncrementOrder(20);
		inventory.setThresholdQuantity(20);
	}
	

	
	@Test
	public void getInventoryItemTest() throws Exception{
		int availQuantity = 100;
		int itemId = 1;
		int noStock = 10;
		int previousOrder = 70;
		int probableIncrement = 20;
		int setThreshold = 20;
		LocalDate dateValue = LocalDate.now();
		assertEquals(availQuantity,inventory.getAvailableQuantity());
		assertEquals(itemId,inventory.getItemId());
		assertEquals(noStock,inventory.getNoStockValue());
		assertEquals(previousOrder,inventory.getPreviousOrderQuantity());
		assertEquals(probableIncrement,inventory.getProbableIncrementOrder());
		assertEquals(setThreshold,inventory.getThresholdQuantity());
		assertEquals(dateValue,inventory.getCurrentOrderDate());
		assertEquals(dateValue,inventory.getCurrentThresholdDate());
		assertEquals(dateValue,inventory.getPreviousOrderDate());
		assertEquals(dateValue,inventory.getPreviousThresoldDate());
		
	}
}
