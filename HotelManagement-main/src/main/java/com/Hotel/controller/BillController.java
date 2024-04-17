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
import com.Hotel.exception.BillNotFoundException;
import com.Hotel.exception.GuestNotFoundException;
import com.Hotel.model.Bill;
import com.Hotel.service.BillService;

@Controller
@RequestMapping("/bill")
public class BillController {
	
	Logger logger=LoggerFactory.getLogger(BillController.class);

	    @Autowired   
	    private BillService service;

	    @GetMapping("/login")
	    public String showLoginPage() {
	       return "login";
	    }
	    @GetMapping("/")
	    public String showHomePage() {
	       return "receptionPage";
	    }
	    @GetMapping("/home")
	    public String showMainPage() {
	       return "mainPage";
	    }
	    @GetMapping("/register")
	    public String showRegistration() {
	       return "registerBillPage";
	    }
	    
	    @GetMapping("/report")
	    public String showReport() {
	       return "reportPage";
	    }

	   
	    @RequestMapping(value="/save", method=RequestMethod.POST)
	    public String saveGuest(@ModelAttribute Bill bill,Model model,RedirectAttributes attributes) 
	    {
			logger.trace("Adding data....");
			
			String redirect;
			try 
			{
		        service.saveBill(bill);
				logger.trace("Data added successfully");
		        Long id = service.saveBill(bill).getBillid();
		        String message = "Record with id : '"+id+"' is saved successfully !";
		        model.addAttribute("message", message);
		        return "registerBillPage";
			}
			catch (GuestNotFoundException e) {
		           e.printStackTrace();
		           logger.error("adding unsuccessful redirection to home page");
		           attributes.addAttribute("message", e.getMessage());
		           redirect="receptionPage";
		          
		       }
			return redirect;
	    }

	    
	    @GetMapping("/getAllBill")
	    public String getAllBill( @RequestParam(value = "message", required = false) String message, Model model ) {
		   
	       logger.trace("Fetching all data");
		   List<Bill> bill= service.getAllBill();
	       model.addAttribute("list", bill);
	       model.addAttribute("message", message);
	       return "allBillPage";
	    }

	    
	    @GetMapping("/edit")
	    public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id )
	    {
		   
	    	logger.trace("Updating data....");
		    Bill bill = service.getBillById(id);
		    if(bill==null)
			  {
				  throw new GuestNotFoundException("Invalid Bill id " + id);
			  }
		    else
		    {
	       model.addAttribute("bill", bill);
	       logger.trace("Updated data successfully with id:"+ id);
		   attributes.addAttribute("message", "Updated id : "+id+" successfully");
	       return"editBillPage";
	       
	       } 

	    }

	    @PostMapping("/update")
	    public String updateGuest(@ModelAttribute Bill bill,RedirectAttributes attributes) 
	    {
	       service.updateBill(bill);
	       Long id = bill.getBillid();
	       logger.trace("Updated data successfully with id:"+ id);
	       attributes.addAttribute("message", "Bill with id: '"+id+"' is updated successfully !");
	       return "redirect:getAllBill";
	    }

	    @GetMapping("/delete")
	    public String deleteGuest(@RequestParam Long id,RedirectAttributes attributes) 
	    {
	    	logger.trace("Deleting data.....");
			String redirect;
			
	        try 
	        {
	        service.deleteBillById(id);
	        attributes.addAttribute("message", "Bill with Id : '"+id+"' is removed successfully!");
	        logger.trace("Deleted data with id:"+ id);
	        redirect="allBillPage";
	        } 
	        catch (BillNotFoundException e) 
	        {
	            e.printStackTrace();
		        logger.error("Deleting unsuccessful redirection to home page");
	            attributes.addAttribute("message", e.getMessage());
	            redirect="allBillPage";
	        }
	        return redirect;
	    }
	}

