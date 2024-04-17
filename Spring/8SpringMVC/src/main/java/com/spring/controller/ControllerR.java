package com.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerR 
{
	@RequestMapping("/load")
	public String loadMyJspFile()
	{
		return "login";
	}
	
	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam("username") String uname,@RequestParam("address") String add)
	{
		ModelAndView model=new ModelAndView();
		model.addObject("Uname", uname);
		model.addObject("address", add);
		model.setViewName("NewFile");
		return model;
	}
}