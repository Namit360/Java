package com.Hotel.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Hotel.exception.ResourceNotFoundException;
import com.Hotel.model.Staff;
import com.Hotel.repository.StaffRepository;
import com.Hotel.service.StaffService;

@Service
public class StaffServiceImplementation implements StaffService {

	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public void addStaff(Staff staff) {
		
		staffRepository.save(staff);
	}
	
	@Override
	public Staff fetchStaffById(int id) {
	
		return staffRepository.findById(id).get();
	}
	@Override
	public String deleteStaffDetails(int id) {
		 
		staffRepository.deleteById(id);
		return "product with id: " + id+" removed";
   }

	@Override
	public List<Staff> fetchAllStaff() {
		
		List<Staff> staff= staffRepository.findAll();
		return staff;
	}

	
	/*
	 * @Override public void updatePost(int id, Staff staff) {
	 * 
	 * Staff staff1 =staffRepository.findById(id).orElse(null);
	 * 
	 * staff1.setStaffName(staff.getStaffName());
	 * staff1.setStaffAddress(staff.getStaffAddress());
	 * staff1.setAge(staff.getAge()); staff1.setSalary(staff.getSalary());
	 * staff1.setEmail(staff.getEmail());
	 * 
	 * 
	 * staffRepository.save(staff1); }
	 */
	
	@Override
	public void updatePost(Staff staff) {
		
		staffRepository.save(staff);
	}
	
	
	
}
	

	

