package com.ecommerce.inventory.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory.exception.ExceptionCodes;
import com.ecommerce.inventory.exception.ProductNotFoundException;
import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.model.dto.InventoryDTO;

import com.ecommerce.inventory.repository.InventoryRepository;
import com.ecommerce.inventory.service.InventoryService;
import com.ecommerce.inventory.util.Convertor;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class InventoryServiceImpl implements InventoryService{
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
	
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private Convertor inventoryConvertor;
	
	@Autowired
	private MessageSource messageSource;
    
	/**
	 * This method inserts the item into inventory repository and returns the inventory dto.
	 * */
	@Override
	public InventoryDTO addInventoryItem(InventoryDTO inventoryDto) {
		logger.info("Adding Item to inventory process started in addInventoryItem method.");
		Inventory inventory = inventoryConvertor.convertDtoToEntity(inventoryDto);
		Inventory savedInventory = inventoryRepository.save(inventory);
		logger.info("Item sucessfully added to inventory repository");
		return inventoryConvertor.convertEntityToDto(savedInventory);
	}

	@Override
	public InventoryDTO updateInventoryItem(InventoryDTO inventoryDto) {
		
		return null;
	}

	@Override
	public boolean deleteInventoryItem(int itemID) {
		logger.info("Deleting the item from inventory started in deleteInventoryItem method");
		Optional<Inventory> existingItem = inventoryRepository.findById(itemID);
		if(existingItem.isEmpty() || existingItem==null) {
			logger.error("No product found for the given Id in inventory");
			throw new ProductNotFoundException(messageSource.getMessage(ExceptionCodes.productNotFoundCode, null, LocaleContextHolder.getLocale()));
		}else {
			inventoryRepository.deleteById(itemID);
			logger.info("Delete inventory item process completed sucessfully.");
			return true;
		}
	}

	@Override
	public int getAvailableQuantity(int itemID) {
		logger.info(" getAvailableQuantity process started ");
		Optional<Inventory> existingItem = inventoryRepository.findById(itemID);
		if(existingItem.isEmpty() || existingItem==null) {
			logger.error("No Item with the given id found in inventory");
			throw new ProductNotFoundException(messageSource.getMessage(ExceptionCodes.productNotFoundCode, null, LocaleContextHolder.getLocale()));
		}else {
			logger.info(" getAvailableQuantity has completed sucessfully ");
			return existingItem.get().getAvailableQuantity();
		}
	}

	@Override
	public InventoryDTO getItemById(int itemId) {
		logger.info("getItemById process started");
		Optional<Inventory> existingItem = inventoryRepository.findById(itemId);
		if(existingItem.isEmpty() || existingItem==null) {
			logger.error("No Item found with the given itemId in inventory");
			throw new ProductNotFoundException(messageSource.getMessage(ExceptionCodes.productNotFoundCode, null,LocaleContextHolder.getLocale()));
		}else {
			logger.info("getItemById process completed sucessfully");;
			return inventoryConvertor.convertEntityToDto(existingItem.get());
		}
	}

	@Override
	public List<InventoryDTO> getAllInventory() {
		logger.info("getAllInventory process started");
		List<Inventory> inventoryItems = inventoryRepository.findAll();
		List<InventoryDTO> inventoryDtoList = new ArrayList<>();
		if(inventoryItems.isEmpty() || inventoryItems == null) {
			logger.warn("No items available in inventory");
			return new ArrayList<>();
		}else {
			inventoryItems.forEach(inventoryItem ->{
				inventoryDtoList.add(inventoryConvertor.convertEntityToDto(inventoryItem));
			});
		}
		logger.info("getAllInventory process completed sucessfully");
		return inventoryDtoList;
	}

}
