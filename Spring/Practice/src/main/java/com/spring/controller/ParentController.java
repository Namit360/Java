package com.spring.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.Parent;
import com.spring.service.ParentService;


@RestController
@RequestMapping("/v1")
public class ParentController 
{
	@Autowired
	ParentService parentService;
	
	@PostMapping("/add")
    public void addStaffInfo(@RequestBody Parent parent)
    {
		parentService.addParent(parent);
    }
	
	@GetMapping("/parent")
	public List<Parent> getParent()
	{
		//return new ResponseEntity<>(parentService.fetchAllParent(), HttpStatus.OK);
		  List<Parent> par = parentService.fetchAllParent(); 
		  return par;
	}
	
	@GetMapping("/parent/{id}")
	public Optional<Parent> getParentID(@PathVariable("id") int id)
	{
		Optional<Parent> parent = parentService.getParentId(id);
		return parent;
		/*
		 * List<Parent> par = parentService.fetchAllParent(); return par;
		 */
	}
	
	/*
	 * @GetMapping("/delete/{id}") public Parent
	 * deleteParentDetails(@PathVariable("id") int id) { return
	 * parentService.deleteParentId(id); }
	 */
}