package com.Hotel.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hotel.exception.ResourceNotFoundException;
import com.Hotel.model.Staff;
import com.Hotel.repository.StaffRepository;
import com.Hotel.service.StaffService;


@Controller
@RequestMapping("/staff")
public class StaffController {
	
	
	Logger logger=LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	StaffService userService;

	@Autowired
	StaffRepository staffRepository;
	
	/*
	 * @GetMapping("/log") public String login() { return "login"; }
	 */
	
	  @GetMapping("/home")
	    public String showHomePage() {
	       return "HomePage";
	    }

	    @GetMapping("/register")
	    public String showRegistration() {
	       return "InputDetails";
	    }
	    
	    @GetMapping("/manager")
	    public String getRoom() {
	       return "ManagerPage";
	    }
	    
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addStaffInfo(@ModelAttribute Staff staff, Model model,RedirectAttributes attributes)
	{
		logger.trace("Adding data....");
		
		String redirect;
		try {
				userService.addStaff(staff);
				logger.trace("Data added successfully");
				String print = "Record is added successfully ";
				model.addAttribute("message", print);
				redirect ="InputDetails";
		}
		catch (ResourceNotFoundException e) {
	           e.printStackTrace();
	           attributes.addAttribute("message", e.getMessage());
	           logger.error("Data  Could Not be Added");
	           redirect="StaffDetails";
	          
	       }
		return redirect;
	}
	
	@GetMapping("/allUser")
	public String getAllStaff(Model model)
	{
		logger.trace("Fetching all data");
		List<Staff> staff = userService.fetchAllStaff();
		model.addAttribute("list",staff);
		return "StaffDetails";
	}
	
	  @GetMapping("/update")
	    public String getEditPage( Model model, RedirectAttributes attributes, @RequestParam int id)
	  {
		  logger.trace("Updating data....");
		  Staff staff=userService.fetchStaffById(id);
		  if(staff==null)
		  {
			  logger.error("Invalid Staff Id");
			  throw new ResourceNotFoundException("Invalid Staff id " + id);
			  
		  }
		  else
		  {
			  model.addAttribute("staff", staff);
			  logger.trace("Updated data successfully with id:"+ id);
			  attributes.addAttribute("message", "Updated id : "+id+" successfully");
			  return "UpdateDetails"; 
	    }
	  }
	  
	  @GetMapping(value = "/fetch/{id}")
	  public String getStaffById(@PathVariable("id") int id,Model model) {
	     
		  logger.trace("Fetching data with id:" + id);
		  Staff staff = userService.fetchStaffById(id);
		  if(staff==null)
		  {
			  logger.error("Invalid Staff Id");
			  throw new ResourceNotFoundException("Invalid Staff id " + id);
		  }
		  else
		  {
			  model.addAttribute("staff", staff);
			  return "ShowDetails";
	  }
	}
	

	@GetMapping("/name/{name}")
	public String getbyName(@PathVariable("name") String name,Model model)	
	{
		 logger.trace("Fetching data by name");
		Staff staff=staffRepository.findBystaffName(name);
		model.addAttribute("staff", staff);
		return "ShowDetails";
	}
	
	
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public String updatePost( @ModelAttribute Staff staff, RedirectAttributes attributes) {
		
		
		userService.updatePost(staff);
		attributes.addAttribute("message", "Updated successfully");
		return "redirect:home";
		

	}
	
	@GetMapping("/delete")
    public String deleteStaff(@RequestParam int id,RedirectAttributes attributes) 
	{
		logger.trace("Deleting data.....");
		String redirect;
		try
		{
			 userService.deleteStaffDetails(id);
		        attributes.addAttribute("message", "Invoice with Id : '"+id+" is deleted successfully!");
		        logger.trace("Deleted data with id:"+ id);
		        redirect="redirect:home";
		}
		catch (ResourceNotFoundException e) {
	           e.printStackTrace();
	           attributes.addAttribute("message", e.getMessage());
	           redirect="StaffDetails";
	          
	       }
       return redirect;
    }
	
}
