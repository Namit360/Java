package com.spring.model.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.Owner;
import com.spring.model.service.OwnerServices;

@RestController
@RequestMapping("/v1")
public class OwnerController 
{
	@Autowired
	OwnerServices ownerService;
	
	@RequestMapping("/load")
	public String loadReport()
	{
		return "Hotel Report .........";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
    public void addStaffInfo(@RequestBody Owner owner)
    {
		ownerService.addUser(owner);
    }
	
	@RequestMapping("/dept")
	public List<Owner> getDepts()
	{
		List<Owner> owner = ownerService.fetchAllDepartment();
		return owner;
	}
	
	@RequestMapping("/delete/{id}")
    public String deleteDeptDetails(@PathVariable("id") int id)
    {
        return ownerService.deleteDeptDetailsbyId(id);
    }
	
	@GetMapping("/staff")
	public Object getStaff()
	{
		return ownerService.fetchStaff();
	}
	
	@GetMapping("/staff/{id}")
	public Object getParent()
	{
		return ownerService.fetchStaffID();
	}	
	/*
	 * @RequestMapping("/staff") public List<Owner> getStaff() { List<Owner>
	 * owner=ownerService.getStaffDetails(); return owner; }
	 * 
	 * @RequestMapping("/room") public List<Owner> getRoom() { List<Owner>
	 * owner=ownerService.getRoomDetails(); return owner; }
	 * 
	 * @RequestMapping("/inv") public List<Owner> getInventory() { List<Owner>
	 * owner=ownerService.getInventoryDetails(); return owner; }
	 * 
	 * @RequestMapping("/gust") public List<Owner> getGuest() { List<Owner>
	 * owner=ownerService.getGuestDetails(); return owner; }
	 * 
	 * @RequestMapping("/resv") public List<Owner> getReservation() { List<Owner>
	 * owner=ownerService.getReservationDetails(); return owner; }
	 * 
	 * @GetMapping("/staff/{department}") public
	 * ResponseEntity<Owner>fetchOneCustomer(@PathVariable("dept") String
	 * department) throws Exception { Optional<Owner>
	 * customer=ownerService.getSingleCustomer(department); if(customer.isPresent())
	 * return ResponseEntity.ok(customer.get()); throw new
	 * Exception("Invalid Department Staff"); }
	 */	 
}