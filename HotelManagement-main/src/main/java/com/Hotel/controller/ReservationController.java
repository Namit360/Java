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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hotel.exception.GuestNotFoundException;
import com.Hotel.exception.ReservationNotFoundException;
import com.Hotel.model.Reservation;
import com.Hotel.service.ReservationService;


@Controller
@RequestMapping("/res")
public class ReservationController {

	Logger logger=LoggerFactory.getLogger(BillController.class);

	
    @Autowired   
    private ReservationService service;

    @GetMapping("/")
    public String showHomePage() {
       return "receptionPage";
    }
    
    @GetMapping("/register")
    public String showRegistration() {
       return "registerReservationPage";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation,Model model,RedirectAttributes attributes)
    {
    	logger.trace("Adding data....");
		
		String redirect;
		try
		{
        service.saveReservation(reservation);
		logger.trace("Data added successfully");
        Long id = service.saveReservation(reservation).getResid();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);
        return "registerReservationPage";
		}
		catch (ReservationNotFoundException e) {
	           e.printStackTrace();
	           logger.error("adding unsuccessful redirection to home page");
	           attributes.addAttribute("message", e.getMessage());
	           redirect="receptionPage";
	          
	       }
		return redirect;
    }
    
    @GetMapping("/getAllRes")
    public String getAllReservation( @RequestParam(value = "message", required = false) String message, Model model) 
    {
	   logger.trace("Fetching all data");
       List<Reservation> reservation= service.getAllReservation();
       model.addAttribute("list", reservation);
       model.addAttribute("message", message);
       return "allReservationPage";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model,RedirectAttributes attributes,@RequestParam Long id) 
    {
    	logger.trace("Updating data....");
 	   Reservation reservation = service.getReservationById(id);
	    if(reservation==null)
		  {
			  throw new GuestNotFoundException("Invalid Reservation id " + id);
		  }
	    else
	    {      
	        model.addAttribute("Reservation", reservation);
	        logger.trace("Updated data successfully with id:"+ id);
			attributes.addAttribute("message", "Updated id : "+id+" successfully");
			return "editReservationPage";
	    }

    }

    @PostMapping("/update")
    public String updateReservation( @ModelAttribute Reservation reservation,RedirectAttributes attributes) 
    {
       service.updateReservation(reservation);
       Long id = reservation.getResid();
       logger.trace("Updated data successfully with id:"+ id);
       attributes.addAttribute("message", "Reservation with id: '"+id+"' is updated successfully !");
       return "redirect:getAllRes";
    }

    @GetMapping("/delete")
    public String deleteReservation( @RequestParam Long id,RedirectAttributes attributes) 
    {
    	logger.trace("Deleting data.....");
		String redirect;
		
    	try 
    	{
        service.deleteReservationById(id);
        attributes.addAttribute("message", "Reservation with Id : '"+id+"' is removed successfully!");
        logger.trace("Deleted data with id:"+ id);
        redirect="AllReservationPage";
        } 
        catch (ReservationNotFoundException e)
        {
            e.printStackTrace();
	        logger.error("Deleting unsuccessful redirection to home page");
            attributes.addAttribute("message", e.getMessage());
            redirect="AllReservationPage";
        }
        return redirect;
    }
}
