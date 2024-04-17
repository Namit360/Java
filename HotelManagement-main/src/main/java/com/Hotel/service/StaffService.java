package com.Hotel.service;

import java.util.List;
import java.util.Optional;

import com.Hotel.model.Staff;

public interface StaffService {

	public void addStaff(Staff staff);
	public List<Staff> fetchAllStaff();
	public Staff fetchStaffById(int id);
	public void updatePost(Staff staff);
	public String deleteStaffDetails(int id);

	
}
