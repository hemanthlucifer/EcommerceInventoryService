package com.ecommerce.inventory.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Inventory implements Serializable {
    
	private static final long serialVersionUID = 1L;


	/**
	 * It represents unique id of the item
	 * */
	@Column(name = "item_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int itemId;
	
	
	/**
	 * It represents quantity available in the inventory.
	 * */
	@Column(name = "available_quantity")
	@Getter
	@Setter
	private int availableQuantity;
	
	/**
	 * It represents threshold quantity for a item.
	 * */
	@Column(name = "threshold_quantity")
	@Getter
	@Setter
	private int thresholdQuantity;
	
	/**
	 * It represents previous quantity for a item.
	 * */
	@Column(name = "previousOrd_quantity")
	@Getter
	@Setter
	private int previousOrderQuantity;
	
	/**
	 * It represents no stock value for a item.
	 * */
	@Column(name = "noStock_value")
	@Getter
	@Setter
	private int noStockValue;
	
	/**
	 * It represents previous date at which threshold is reached for a item.
	 * */
	@Column(name = "prnoStock_value")
	@Getter
	@Setter
	private LocalDate previousThresoldDate;
	
	/**
	 * It represents current date at which threshold is reached for a item.
	 * */
	@Column(name = "crthreshold_value")
	@Getter
	@Setter
	private LocalDate currentThresholdDate;
	
	/**
	 * It represents previous date on which order is kept for a item.
	 * */
	@Column(name = "prOrder_date")
	@Getter
	@Setter
	private LocalDate previousOrderDate;
	
	/**
	 * It represents current date on which order is kept for a item.
	 * */
	@Column(name = "crOrder_date")
	@Getter
	@Setter
	private LocalDate currentOrderDate;
	
	/**
	 * It represents probable increment in order for next order.
	 * */
	@Column(name = "probableIncrement")
	@Getter
	@Setter
	private double probableIncrementOrder;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return getAvailableQuantity() == inventory.getAvailableQuantity() &&
                getItemId() == inventory.getItemId() &&
                getNoStockValue() == inventory.getNoStockValue() &&
                getPreviousOrderQuantity() == inventory.getPreviousOrderQuantity() &&
                getProbableIncrementOrder() == inventory.getProbableIncrementOrder() &&
                getThresholdQuantity() == inventory.getThresholdQuantity() &&
                Objects.equals(getCurrentOrderDate(), inventory.getCurrentOrderDate()) &&
                Objects.equals(getCurrentThresholdDate(), inventory.getCurrentThresholdDate()) &&
                Objects.equals(getPreviousOrderDate(), inventory.getPreviousOrderDate()) &&
                Objects.equals(getPreviousThresoldDate(), inventory.getPreviousThresoldDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAvailableQuantity(), getItemId(), getNoStockValue(),
                getPreviousOrderDate(), getPreviousOrderQuantity(), getPreviousThresoldDate(),
                getCurrentOrderDate(), getCurrentThresholdDate(), getProbableIncrementOrder(),
                getThresholdQuantity());
    }
	
}
