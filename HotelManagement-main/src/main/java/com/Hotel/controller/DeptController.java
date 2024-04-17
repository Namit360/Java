package com.Hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hotel.exception.DeptNotFoundException;
import com.Hotel.model.Department;
import com.Hotel.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {

	    @Autowired   
	    private DeptService service;

	    @GetMapping("/home")
	    public String showHomePage1() {
	       return "mainPage";
	    }
	    
	    @GetMapping("/")
	    public String showHomePage() {
	       return "deptPage";
	    }

	    @GetMapping("/register")
	    public String showRegistration() {
	       return "registerDeptPage";
	    }

	    @PostMapping("/save")
	    public String saveDept(
	            @ModelAttribute Department dept,
	            Model model
	            ) {
	        service.saveDept(dept);
	        Long id = service.saveDept(dept).getDeptid();
	        String message = "Record with id : '"+id+"' is saved successfully !";
	        model.addAttribute("message", message);
	        return "registerDeptPage";
	    }

	    @GetMapping("/getAllDept")
	    public String getAllDept(
	            @RequestParam(value = "message", required = false) String message,
	            Model model
	            ) {
	       List<Department> dept= service.getAllDept();
	       model.addAttribute("list", dept);
	       model.addAttribute("message", message);
	       return "allDeptPage";
	    }

	    @GetMapping("/edit")
	    public String getEditPage(
	            Model model,
	            RedirectAttributes attributes,
	            @RequestParam Long id
	            ) {
	       String page = null; 
	       try {
	       Department dept = service.getDeptById(id);
	       model.addAttribute("dept", dept);
	       page="editDeptPage";
	       } catch (DeptNotFoundException e) {
	           e.printStackTrace();
	           attributes.addAttribute("message", e.getMessage());
	           page="getAllDept";
	       }
	       return page; 
	    }

	    @PostMapping("/update")
	    public String updateDept(
	            @ModelAttribute Department dept,
	            RedirectAttributes attributes
	            ) {
	       service.updateDept(dept);
	       Long id = dept.getDeptid();
	       attributes.addAttribute("message", "Dept with id: '"+id+"' is updated successfully !");
	       return "redirect:getAllDept";
	    }

	    @GetMapping("/delete")
	    public String deleteDept(
	            @RequestParam Long id,
	            RedirectAttributes attributes
	            ) {
	        try {
	        service.deleteDeptById(id);
	        attributes.addAttribute("message", "Dept with Id : '"+id+"' is removed successfully!");
	        } catch (DeptNotFoundException e) {
	            e.printStackTrace();
	            attributes.addAttribute("message", e.getMessage());
	        }
	        return "redirect:getAllDept";
	    }
	}

