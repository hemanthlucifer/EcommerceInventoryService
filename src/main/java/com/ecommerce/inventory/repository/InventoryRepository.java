package com.ecommerce.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

}
