package com.spring.service;

import java.util.List;
import java.util.Optional;
import com.spring.model.Inventory;


public interface InventoryService {

	public void addInventories(Inventory inventory);
	public List<Inventory> fetchAllInventories();
	public Optional<Inventory> fetchInventoryfById(int id);
	public void updateInventory(Inventory inventory);
	//public void updatePost(int id,Inventory inventory)
	public String deleteInventoryDetails(int id);
}
