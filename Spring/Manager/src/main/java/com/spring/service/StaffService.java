package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.model.Staff;

public interface StaffService {

	public void addStaff(Staff staff);
	public List<Staff> fetchAllStaff();
	public Optional<Staff> fetchStaffById(int id);
	//public void updateStaff(Staff staff);
	public void updatePost(int id, Staff staff);
	public String deleteStaffDetails(int id);

	
}
