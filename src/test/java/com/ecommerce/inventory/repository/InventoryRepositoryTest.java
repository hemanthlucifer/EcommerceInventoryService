package com.ecommerce.inventory.repository;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.ecommerce.inventory.model.Inventory;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class InventoryRepositoryTest {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	Inventory inventory;
	
	@BeforeEach
	void setupItem() {
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
		inventory = entityManager.merge(inventory);
	}

	@Test
	void testFindById() {
		int itemId = 1;
		Optional<Inventory> inventoryItem = inventoryRepository.findById(itemId);
		assertNotNull(inventoryItem.get());
		assertEquals(inventoryItem.get().getAvailableQuantity(),inventory.getAvailableQuantity());
	
	}

}
