package com.ecommerce.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.inventory.model.dto.InventoryDTO;


public interface InventoryService {
	
	public InventoryDTO addInventoryItem(InventoryDTO inventoryDto);
	public InventoryDTO updateInventoryItem(InventoryDTO inventoryDto);
	public boolean deleteInventoryItem(int itemID);
	public int getAvailableQuantity(int itemID);
	public InventoryDTO getItemById(int itemId);
	public List<InventoryDTO> getAllInventory();

}
