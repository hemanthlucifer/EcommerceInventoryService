package com.ecommerce.inventory.web;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.model.dto.InventoryDTO;
import com.ecommerce.inventory.repository.InventoryRepository;
import com.ecommerce.inventory.service.InventoryService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@RunWith(SpringRunner.class)
@WebMvcTest(InventoryController.class)
class InventoryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private InventoryRepository inventoryRepository;
	
	@MockBean
	private InventoryService inventoryService;
	
	Inventory inventory;
	
	InventoryDTO inventoryDTO;
	
	@BeforeEach
	void setupControllerTest() {
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
		inventoryDTO.setItemId(1);
		inventoryDTO.setNoStockValue(10);
		inventoryDTO.setPreviousOrderDate(LocalDate.now());
		inventoryDTO.setPreviousOrderQuantity(70);
		inventoryDTO.setPreviousThresoldDate(LocalDate.now());
		inventoryDTO.setProbableIncrementOrder(20);
		inventoryDTO.setThresholdQuantity(20);
	}

	@Test
	void testAddItem() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(inventoryDTO);
		when(inventoryService.addInventoryItem(inventoryDTO)).thenReturn(inventoryDTO);
		this.mockMvc.perform(post("/inventory/addItem").contentType(MediaType.APPLICATION_JSON)
				.content(requestJson)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetItemById() throws Exception {
		int  itemId = 1;
		//when(inventoryRepository.findById(itemId)).thenReturn(Optional.of(inventory));
		when(inventoryService.getItemById(itemId)).thenReturn(inventoryDTO);
		this.mockMvc.perform(get("/inventory/getItem/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetQuantityByItemId() throws Exception {
		int itemId = 1;
		when(inventoryService.getAvailableQuantity(itemId)).thenReturn(inventory.getAvailableQuantity());
		this.mockMvc.perform(get("/inventory/getQuantity/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testDeleteByItemId() throws Exception{
		int itemId = 1;
		when(inventoryService.deleteInventoryItem(itemId)).thenReturn(true);
		this.mockMvc.perform(delete("/inventory/deleteItem/1")).andDo(print()).andExpect(status().isOk());
	}

}
