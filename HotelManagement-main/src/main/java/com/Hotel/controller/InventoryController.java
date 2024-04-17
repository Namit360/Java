package com.Hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hotel.exception.ResourceNotFoundException;
import com.Hotel.model.Inventory;
import com.Hotel.service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

	Logger logger=LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	InventoryService inventoryService;
	
	  @GetMapping("/home")
	    public String showHomePage() {
	       return "HomePage2";
	    }

	    @GetMapping("/addDetails")
	    public String showRegistration() {
	       return "InputDetails2";
	    }
	    

	@PostMapping(value="/add")
	public String addStaffInfo(@ModelAttribute Inventory inventory, Model model,RedirectAttributes attributes)
	{
		logger.trace("Adding data....");
		String redirect;
		try {
				inventoryService.addInventories(inventory);
				logger.trace("Data added successfully");
				String print = "Record is added successfully !";
				model.addAttribute("message", print);
				redirect ="InputDetails2";
		}
		catch (ResourceNotFoundException e) {
	           e.printStackTrace();
	           attributes.addAttribute("message", e.getMessage());
	           logger.error("Data Could Not Be Added");
	           redirect="StaffDetails2";
	          
	       }
		return redirect;
	}
	
	
	
	@RequestMapping("/allInventories")
	public String getAllInventories(Model model)
	{
		logger.trace("Fetching all data");
		List<Inventory> inventory = inventoryService.fetchAllInventories();
		model.addAttribute("lists",inventory);
		return "StaffDetails2";
	}
	
	@GetMapping("/update")	
	public String updateInventoryInfo(Model model, RedirectAttributes attributes, @RequestParam int id)
	{
		 logger.trace("Updating data....");
		Inventory inventory=inventoryService.fetchInventoryfById(id);
		 if(inventory==null)
		  {
			  logger.error("Invalid Staff id");
			  throw new ResourceNotFoundException("Invalid Staff id " + id);
		  }
		  else
		  {
			  model.addAttribute("inventory", inventory);
			  logger.trace("Updated data successfully with id:"+ id);
			  attributes.addAttribute("message", "Updated id : "+id+" successfully");
			  return "UpdateDetails2"; 
	    }
		
	}
		
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public String updatePost( @ModelAttribute Inventory inventory, RedirectAttributes attributes) {
		
		
		inventoryService.updatePost(inventory);
		attributes.addAttribute("message", "Updated successfully");
		return "redirect:home";
		

	}
	
	@GetMapping("/delete")
    public String deleteInventory(@RequestParam int id,RedirectAttributes attributes)
	{
		logger.trace("Deleting data.....");
		String redirect;
		try
		{
			inventoryService.deleteInventoryDetails(id);
			 logger.trace("Deleted data with id:"+ id);
		    attributes.addAttribute("message", "Invoice with Id : '"+id+" is deleted successfully!");
		    redirect="redirect:home";
		}
		catch (ResourceNotFoundException e) {
	           e.printStackTrace();
	           attributes.addAttribute("message", e.getMessage());
	           redirect="StaffDetails2";
	          
	       }
       return redirect;
    }
   
}
