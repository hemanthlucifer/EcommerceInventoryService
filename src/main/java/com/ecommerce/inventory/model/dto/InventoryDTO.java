package com.ecommerce.inventory.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

public class InventoryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;


	/**
	 * It represents unique id of the item
	 * */
	@Getter
	@Setter
	private Integer itemId;
	
	
	/**
	 * It represents quantity available in the inventory.
	 * */
	@Getter
	@Setter
	private int availableQuantity;
	
	/**
	 * It represents threshold quantity for a item.
	 * */
	@Getter
	@Setter
	private int thresholdQuantity;
	
	/**
	 * It represents previous quantity for a item.
	 * */
	@Getter
	@Setter
	private int previousOrderQuantity;
	
	/**
	 * It represents no stock value for a item.
	 * */
	@Getter
	@Setter
	private int noStockValue;
	
	/**
	 * It represents previous date at which threshold is reached for a item.
	 * */
	@Getter
	@Setter
	private LocalDate previousThresoldDate;
	
	/**
	 * It represents current date at which threshold is reached for a item.
	 * */
	@Getter
	@Setter
	private LocalDate currentThresholdDate;
	
	/**
	 * It represents previous date on which order is kept for a item.
	 * */
	@Getter
	@Setter
	private LocalDate previousOrderDate;
	
	/**
	 * It represents current date on which order is kept for a item.
	 * */
	@Getter
	@Setter
	private LocalDate currentOrderDate;
	
	/**
	 * It represents probable increment in order for next order.
	 * */
	@Getter
	@Setter
	private double probableIncrementOrder;
	
	/**
	 *It represents image link for the item. 
	 **/
	@Column(name="image")
	@Getter
	@Setter
	private String imageLink;

}
