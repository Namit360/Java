package com.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Customer;

@Controller
public class CustController 
{
	@RequestMapping("/load")
	public String loadMyJspFile(@ModelAttribute("custobj") Customer cust)
	{
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("custObj") Customer cust)
	{
		ModelAndView model=new ModelAndView();
		model.addObject("customer", cust);
		model.setViewName("NewFile");
		return model;
	}
}