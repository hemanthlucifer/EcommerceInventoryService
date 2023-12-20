package com.ecommerce.inventory.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.model.dto.InventoryDTO;


@Component
public class Convertor {
	
	private static final Logger logger = LoggerFactory.getLogger(Convertor.class);
   
	public InventoryDTO convertEntityToDto(Inventory inventory) {
		logger.info("convertEntityToDto process started");
		InventoryDTO inventoryDto = new InventoryDTO();
		inventoryDto.setItemId(inventory.getItemId());
		inventoryDto.setAvailableQuantity(inventory.getAvailableQuantity());
		inventoryDto.setCurrentOrderDate(inventory.getCurrentOrderDate());
		inventoryDto.setCurrentThresholdDate(inventory.getCurrentThresholdDate());
		inventoryDto.setNoStockValue(inventory.getNoStockValue());
		inventoryDto.setPreviousOrderDate(inventory.getPreviousOrderDate());
		inventoryDto.setPreviousOrderQuantity(inventory.getPreviousOrderQuantity());
		inventoryDto.setPreviousThresoldDate(inventory.getPreviousThresoldDate());
		inventoryDto.setProbableIncrementOrder(inventory.getProbableIncrementOrder());
		inventoryDto.setThresholdQuantity(inventory.getThresholdQuantity());
		inventoryDto.setImageLink(inventory.getImageLink());
		logger.info("convertEntityToDto completed sucsessfully");
		return inventoryDto;
	}
	
	public Inventory convertDtoToEntity(InventoryDTO inventoryDto) {
		logger.info("convertDtoToEntity process started");
		Inventory inventory = new Inventory();
		inventory.setAvailableQuantity(inventoryDto.getAvailableQuantity());
		inventory.setCurrentOrderDate(inventoryDto.getCurrentOrderDate());
		inventory.setCurrentThresholdDate(inventoryDto.getCurrentThresholdDate());
		inventory.setNoStockValue(inventoryDto.getNoStockValue());
		inventory.setPreviousOrderDate(inventoryDto.getPreviousOrderDate());
		inventory.setPreviousOrderQuantity(inventoryDto.getPreviousOrderQuantity());
		inventory.setPreviousThresoldDate(inventoryDto.getPreviousThresoldDate());
		inventory.setProbableIncrementOrder(inventoryDto.getProbableIncrementOrder());
		inventory.setThresholdQuantity(inventoryDto.getThresholdQuantity());
		inventory.setImageLink(inventoryDto.getImageLink());
		logger.info("convertDtoToEntity completed sucessfully");
		return inventory;
	}
	
	
}
