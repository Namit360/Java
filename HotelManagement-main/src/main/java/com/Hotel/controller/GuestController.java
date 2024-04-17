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

import com.Hotel.exception.GuestNotFoundException;
import com.Hotel.model.Guest;
import com.Hotel.service.GuestService;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	Logger logger=LoggerFactory.getLogger(GuestController.class);


	    @Autowired   
	    private GuestService service;

	    @GetMapping("/")
	    public String showHomePage() {
	       return "receptionPage";
	    }

	    @GetMapping("/register")
	    public String showRegistration() {
	       return "registerGuestPage";
	    }

		@RequestMapping(value="/save", method=RequestMethod.POST)
	    public String saveGuest(@ModelAttribute Guest guest,Model model,RedirectAttributes attributes)
		{
			logger.trace("Adding data....");
			
			String redirect;
			try 
			{
	        service.saveGuest(guest);
			logger.trace("Data added successfully");
	        Long id = service.saveGuest(guest).getGuestid();
	        String message = "Record with id : '"+id+"' is saved successfully !";
	        model.addAttribute("message", message);
	        return "registerGuestPage";
			}
			catch (GuestNotFoundException e) {
		           e.printStackTrace();
		           logger.error("Failed to add guest data");
		           attributes.addAttribute("message", e.getMessage());
		           redirect="StaffDetails";
		          
		       }
			return redirect;
	    }

	    @GetMapping("/getAllGuest")
	    public String getAllInvoices(@RequestParam(value = "message", required = false) String message,Model model)
	    {
		   logger.trace("Fetching all data");
	       List<Guest> guests= service.getAllGuest();
	       model.addAttribute("list", guests);
	       model.addAttribute("message", message);
	       return "allGuestPage";
	    }

	    
	    @GetMapping("/edit")
	    public String getEditPage(Model model,RedirectAttributes attributes,@RequestParam Long id) 
	    {
	    	
	    	 logger.trace("Updating data....");
		       Guest guest = service.getGuestById(id);
			  if(guest==null)
			  {
				  throw new GuestNotFoundException("Invalid Guest id " + id);
			  }
			  
			  else
			  {
			       model.addAttribute("guest", guest);
				   logger.trace("Updated data successfully with id:"+ id);
				   attributes.addAttribute("message", "Updated id : "+id+" successfully");
				   return "editGuestPage";

			  }
	    }

	    @PostMapping("/update")
	    public String updateGuest(@ModelAttribute Guest guest,RedirectAttributes attributes)
	    {
	       service.updateGuest(guest);
	       Long id = guest.getGuestid();
	       logger.trace("Updated data successfully with id:"+ id);
	       attributes.addAttribute("message", "Guest with id: '"+id+"' is updated successfully !");
	       return "redirect:getAllGuest";
	    }

	    @GetMapping("/delete")
	    public String deleteGuest( @RequestParam Long id,RedirectAttributes attributes)
	    {
	    	logger.trace("Deleting data.....");
			String redirect;
	        
			try 
			{
	        service.deleteGuestById(id);
	        attributes.addAttribute("message", "Guest with Id : '"+id+"' is removed successfully!");
	        logger.trace("Deleted data with id:"+ id);
	        redirect="allGuestPage";
	        } 
			catch (GuestNotFoundException e)
			{
	            e.printStackTrace();
		        logger.error("Deleting unsuccessful redirection to home page");
	            attributes.addAttribute("message", e.getMessage());
	            redirect="getAllGuest";
	        }
	        return redirect;
	    }
	    
	    @GetMapping("\rest")
	    public Object getRoom()
	    {
			return service.fetchRoom();
	    	
	    }
	}

