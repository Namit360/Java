package com.spring.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.Staff;
import com.spring.repository.StaffRepository;
import com.spring.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	StaffService userService;

	@Autowired
	StaffRepository staffRepository;
	

	@PostMapping(value="/fetch")
	public void addStaffInfo(@RequestBody Staff staff)
	{
		userService.addStaff(staff);
	}
	
	/*
	 * @RequestMapping("/user/{id}") public Staff getStaffById(@PathVariable("id")
	 * int id) { Staff staff = userService.fetchStaffById(id); return staff; }
	 */
	
	@GetMapping("/add/{id}")
	public ResponseEntity<Staff> getStaffById(@PathVariable("id") int id)
	{
		Optional<Staff> staff=userService.fetchStaffById(id);
		if(staff.isPresent())
		 return ResponseEntity.ok(staff.get());
		 throw new ResourceNotFoundException("Resource not Found:Invalid staff Id");
	}
	
	@GetMapping("/allUser")
	public List<Staff> getAllStaff()
	{
		List<Staff> staff = userService.fetchAllStaff();
		return staff;
	}
	
	@GetMapping("/name/{name}")
	public Staff getbyName(@PathVariable("name") String name)	
	{
		Staff staff=staffRepository.findBystaffName(name);
		return staff;
	}
	
	
	
	@PutMapping(value="/post/{id}")
	public void updatePost(@PathVariable int id, @RequestBody Staff staff) {

		userService.updatePost(id, staff);

	}
	
	@DeleteMapping("/delete/{id}")
    public String deleteStaff(@PathVariable int id) {
		
        return userService.deleteStaffDetails(id);
    }
		
}
