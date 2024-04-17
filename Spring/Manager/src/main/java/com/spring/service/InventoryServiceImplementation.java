package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Inventory;
import com.spring.repository.InventoryRepository;


@Service
public class InventoryServiceImplementation implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public void addInventories(Inventory inventory) {
		
		inventoryRepository.save(inventory);
	}
		
	@Override
	public List<Inventory> fetchAllInventories() {
		
		List<Inventory> inventory= inventoryRepository.findAll();
		return inventory;
		
	}
	
	@Override
	public Optional<Inventory> fetchInventoryfById(int id) {
		
		return inventoryRepository.findById(id);
		
	}

	@Override
	public void updateInventory(Inventory inventory) {
		
		inventoryRepository.save(inventory);
	}

	@Override
	public String deleteInventoryDetails(int id) {
		
		inventoryRepository.deleteById(id);
		return "product with id: " + id+" removed";
		
	}

	
		
}
