package com.Hotel.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.model.Inventory;
import com.Hotel.model.Staff;
import com.Hotel.repository.InventoryRepository;
import com.Hotel.service.InventoryService;


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
	public String deleteInventoryDetails(int id) {
		
		inventoryRepository.deleteById(id);
		return "product with id: " + id+" removed";
		
	}

	@Override
	public void updateInventory(int id, Inventory inventory) {
			
		Inventory inventory1 =inventoryRepository.findById(id).orElse(null);	
		inventory1.setNo_Of_Blankets(inventory1.getNo_Of_Blankets());
		inventory1.setNo_Of_Towels(inventory1.getNo_Of_Towels());
		inventory1.setNo_Of_Toiletries(inventory1.getNo_Of_Toiletries());
		inventory1.setNo_Of_WaterBottles(inventory1.getNo_Of_WaterBottles());
		
		inventoryRepository.save(inventory1);
		}

	@Override
	public Inventory fetchInventoryfById(int id) {
		return inventoryRepository.findById(id).get();
	}

	@Override
	public void updatePost(Inventory inventory) {
		
		inventoryRepository.save(inventory);
		
	}
		
		
}

	
		

