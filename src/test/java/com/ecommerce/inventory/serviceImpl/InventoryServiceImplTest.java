package com.ecommerce.inventory.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.boot.test.context.SpringBootTest;


import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.model.dto.InventoryDTO;
import com.ecommerce.inventory.repository.InventoryRepository;

import com.ecommerce.inventory.util.Convertor;


@SpringBootTest
class InventoryServiceImplTest {
	
	@InjectMocks
	private InventoryServiceImpl inventoryService;
	
	@Mock
	private InventoryRepository inventoryRepository;
	
	@Mock
	private Convertor inventoryConvertor;
	
	Inventory inventory;
	
	InventoryDTO inventoryDTO;
	
	@BeforeEach
	public void setupItem() {
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
		
		inventoryDTO = new InventoryDTO();
		inventoryDTO.setAvailableQuantity(100);
		inventoryDTO.setCurrentOrderDate(LocalDate.now());
		inventoryDTO.setCurrentThresholdDate(LocalDate.now());
		inventoryDTO.setNoStockValue(10);
		inventoryDTO.setPreviousOrderDate(LocalDate.now());
		inventoryDTO.setPreviousOrderQuantity(70);
		inventoryDTO.setPreviousThresoldDate(LocalDate.now());
		inventoryDTO.setProbableIncrementOrder(20);
		inventoryDTO.setThresholdQuantity(20);
	}

	@Test
	void testAddInventoryItem() {
		
		when(inventoryRepository.save(inventory)).thenReturn(inventory);
		assertEquals(inventory.getAvailableQuantity(),100);
		assertEquals(inventory.getCurrentOrderDate(),LocalDate.now());
		assertEquals(inventory.getCurrentThresholdDate(),LocalDate.now());
		assertEquals(inventory.getItemId(),1);
		assertEquals(inventory.getNoStockValue(),10);
		assertEquals(inventory.getPreviousOrderDate(),LocalDate.now());
		assertEquals(inventory.getPreviousOrderQuantity(),70);
		assertEquals(inventory.getPreviousThresoldDate(),LocalDate.now());
		assertEquals(inventory.getProbableIncrementOrder(),20);
		assertEquals(inventory.getThresholdQuantity(),20);
		
	}
	
	@Test
	void testGetItemQuantity() {
		int itemId = 1;
		int itemQuantity = 100;
		when(inventoryRepository.findById(itemId)).thenReturn(Optional.of(inventory));
		assertEquals(inventory.getAvailableQuantity(),itemQuantity);
	}
	
	void testGetItemById() {
		int itemId = 1;
		when(inventoryRepository.findById(itemId)).thenReturn(Optional.of(inventory));
		assertEquals(inventory.getItemId(),itemId);
	}

	
}
