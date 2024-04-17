package com.Hotel.service;

import java.util.List;
import java.util.Optional;

import com.Hotel.model.Inventory;


public interface InventoryService {

	public void addInventories(Inventory inventory);
	public List<Inventory> fetchAllInventories();
	public Inventory fetchInventoryfById(int id);
	public String deleteInventoryDetails(int id);
	public void updateInventory(int id, Inventory inventory);
	public void updatePost(Inventory inventory);
}
