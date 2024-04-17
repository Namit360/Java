package com.spring.model.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.model.Inventory;
import com.spring.model.Owner;
import com.spring.model.exception.ResourceNotFoundException;
import com.spring.model.service.OwnerServices;

@RestController
@RequestMapping("/v1")
public class OwnerController 
{
	@Autowired
	OwnerServices ownerService;
	
	//Logger logger =LoggerFactory.getLogger(OwnerController.class);
	
	@RequestMapping("/load")
	public String loadReport()
	{
		return "Hotel Report .........";
	}
	
	@GetMapping("/home")
	public String showHomePage()
	{
		return "HomePage";
	}
	
	@GetMapping("/reg")
	public String showRegistration() {
		return "departmentPage";
	}
	
	/*
	 * @PostMapping("/add") public void addStaffInfo(@RequestBody Owner owner) {
	 * ownerService.addDept(owner); 
	 * logger.info("added values");}
	 */
	
	@PostMapping("/savedepts")
	public String saveGuest(@ModelAttribute Owner dep, Model model) 
	{
		ownerService.addDept(dep);
		int id = ownerService.addDept(dep).getDeptid();
		String message = "Record with department id : '" + id + "' is saved successfully !";
		model.addAttribute("message", message);
		return "departmentPage";
	}
	
	@GetMapping("/alldepts")
	public String getAllDepartment(@RequestParam(value = "message", required = false) String message, Model model) 
	{
		List<Owner> dep = ownerService.fetchAlldept();
		model.addAttribute("list", dep);
		model.addAttribute("message", message);
		return "allDepartmentPage";
	}
	
	@GetMapping("/owner/id")
	 public ResponseEntity<Owner> getOwnerDetailsbyId(@PathVariable("id") int id) 
	 {
		Optional<Owner> owner = ownerService.fetchDeptDetailsbyId(id);
		if (owner.isPresent())
		{
           return ResponseEntity.ok(owner.get());
        } 
		else
		{
           throw new ResourceNotFoundException("Id not found");
        }
	 }
	

	@PostMapping("/editdepts")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam int id) 
	{
		String page = null;
		try 
		{
			Optional<Owner> owner = ownerService.fetchDeptDetailsbyId(id);
			model.addAttribute("dep", owner);
			page = "editDept";
		} 
		catch (ResourceNotFoundException e) 
		{
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:dep";
		}
		return page;
	}
	
	/*
	 * @PutMapping("updatebyID/{id}") public void
	 * updateDeptDetailsbyId(@PathVariable int id, @RequestBody Owner dept) { if
	 * (ownerService.fetchDeptDetailsbyId(id).isPresent())
	 * ownerService.updateDeptDetails(id, dept); else throw new
	 * ResourceNotFoundException("not valid id"); }
	 */
	
	@RequestMapping("/depts")
	public List<Owner> getDepts()
	{
		List<Owner> owner = ownerService.fetchAlldept();
		return owner;
	}
	
	@GetMapping("/deletedept")
    public String deleteGuest( @RequestParam int id,RedirectAttributes attributes)
	{
        try 
        {
        	ownerService.deleteDeptDetailsbyId(id);
        	attributes.addAttribute("message", "Invoice with Id : '"+id+"' is removed successfully!");
        } 
        catch (ResourceNotFoundException e) 
        {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:dep";
    }
	
	/*
	 * @RequestMapping("/delete/{id}") public String
	 * deleteDeptDetails(@PathVariable("id") int id) { if
	 * (ownerService.fetchDeptDetailsbyId(id).isPresent()) return
	 * ownerService.deleteDeptDetailsbyId(id); else throw new
	 * ResourceNotFoundException("not valid id"); }
	 */
	
	@GetMapping("/staff")
	public Object getStaff()
	{
		return ownerService.fetchStaff();
	}
	
	/*
	 * @GetMapping("/staff/{id}") public Object getStaffID() { return
	 * ownerService.fetchStaffID(); }
	 */
	
	@GetMapping("/inventory")
	public Object getInventory()
	{
		return ownerService.fetchInventory();
	}
	
	
	
	/*
	 * @PostMapping("/addstaff") public void addUsers(@RequestBody Object staff) {
	 * ownerService.addStaff(staff); }
	 */
	
	/*
	 * @PostMapping("/addstaff") public String addUsers(@ModelAttribute Staff
	 * staff,Model model,RedirectAttributes attributes) { String redirect;
	 * ownerService.addStaff(staff); String print = "added";
	 * model.addAttribute("message",print); redirect="StaffDetails"; return redirect;
	 * }
	 */
	 
	
	@PostMapping("/addinvontary")
	public void addInventory(@RequestBody Inventory inventory)
	{
		ownerService.addDetails(inventory);
	}
	
	@GetMapping("/getbills")
	public Object getBills()
	{
		return ownerService.fetchGuest();
	}
}