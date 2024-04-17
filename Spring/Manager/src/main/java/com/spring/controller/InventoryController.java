package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.ResourceNotFoundException;
import com.spring.model.Inventory;
import com.spring.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	

	@RequestMapping(value="/Add", method=RequestMethod.POST)
	public void addInventoryInfo(@RequestBody Inventory inventory)
	{
		inventoryService.addInventories(inventory);
	}
	
	
	
	@RequestMapping("/add/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") int id)
	{
		Optional<Inventory> inventory=inventoryService.fetchInventoryfById(id);
		if(inventory.isPresent())
		 return ResponseEntity.ok(inventory.get());
		 throw new ResourceNotFoundException("Resource not Found:Invalid staff Id");
	}
	
	@RequestMapping("/allInventories")
	public List<Inventory> getAllInventories()
	{
		List<Inventory> inventory = inventoryService.fetchAllInventories();
		return inventory;
	}
	
		
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public void updateInventoryInfo( @RequestBody Inventory inventory)
	{
		inventoryService.updateInventory(inventory);
	}
	
	
	@RequestMapping("/delete/{id}")
    public String deleteInventory(@PathVariable int id) {
        return inventoryService.deleteInventoryDetails(id);
    }
}
