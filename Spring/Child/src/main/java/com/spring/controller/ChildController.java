package com.spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.Child;
import com.spring.service.ChildService;

@RestController
@RequestMapping("/v1")
public class ChildController 
{
	@Autowired
	ChildService childservice;
	
	@GetMapping("/parent")
	public Object getParent()
	{
		return childservice.fetchParent();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
    public void addChildInfo(@RequestBody Child child)
    {
		childservice.addChild(child);
    }
	
	@RequestMapping("/child")
	public List<Child> getchild()
	{
		List<Child> child = childservice.fetchAllChild();
		return child;
	}
	
	@RequestMapping("/child/{id}")
    public String deleteChildDetails(@PathVariable("id") int id)
    {
        return childservice.deleteChildId(id);
    }
	
}