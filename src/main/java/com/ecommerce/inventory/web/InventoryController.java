package com.ecommerce.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventory.model.dto.InventoryDTO;

import com.ecommerce.inventory.service.InventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info = @Info(title="Inventory Microservices", version="v1.0",
description = "Through this controller we can add items into the inventory and also delete, update and get the stock value of the item"))
@Api(value = "Inventory Services Controller", tags = "Inventory Controller")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Created the item",response=InventoryDTO.class),
			@ApiResponse(code= 400, message="Bad Request"),
			@ApiResponse(code = 500, message = "Something went wrong")
	})
	@ApiOperation(value="Adds item to the inventory", notes = "It adds the item to the inventory", nickname = "add inventory")
	@PostMapping("/addItem")
	public ResponseEntity<InventoryDTO> addInventoryItem(@RequestBody InventoryDTO inventoryDTO){
		InventoryDTO responseDto = inventoryService.addInventoryItem(inventoryDTO);
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "found the item by ID", response=InventoryDTO.class),
			@ApiResponse(code = 404, message = "Product not found"),
			@ApiResponse(code=500, message= "Something went wrong")
	})
	@ApiOperation(value = "get item", notes = "Used to fetch a particular product from the inventory by using product Id", nickname="Get product by id")
	@GetMapping("/getItem/{itemId}")
	public ResponseEntity<InventoryDTO> getInventoryItem(@PathVariable int itemId){
		InventoryDTO responseDto = inventoryService.getItemById(itemId);
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "got the quantity", response=Integer.class),
			@ApiResponse(code = 404, message = "Product not found"),
			@ApiResponse(code=500, message= "Something went wrong")
	})
	@ApiOperation(value = "get quantity", notes = "Used to fetch quantity of particular product from the inventory by using product Id", nickname="Get product quantity by id")
	@GetMapping("/getQuantity{itemId}")
	public ResponseEntity<Integer>getItemQuantity(@PathVariable int itemId){
		return new ResponseEntity<>(inventoryService.getAvailableQuantity(itemId),HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "get all the items", response=InventoryDTO.class),
			@ApiResponse(code=500, message= "Something went wrong")
	})
	@ApiOperation(value = "get quantity", notes = "Used to fetch all the items in a inventory", nickname="Get all items")
	@GetMapping("/getItems")
	public ResponseEntity<List<InventoryDTO>>getAllInventoryItems(){
		List<InventoryDTO> inventoryItems = inventoryService.getAllInventory();
		return new ResponseEntity<>(inventoryItems,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "deleted the item"),
			@ApiResponse(code=404, message = "product not found"),
			@ApiResponse(code=500, message= "Something went wrong")
	})
	@ApiOperation(value = "delete product", notes = "Used to delete a item by item ID", nickname="delete the item")
	@DeleteMapping("/deleteItem/{itemId}")
	public ResponseEntity<Object>deleteInventory(@PathVariable int itemId){
		inventoryService.deleteInventoryItem(itemId);
			return new ResponseEntity<>(null,HttpStatus.OK);
		
	}

}
