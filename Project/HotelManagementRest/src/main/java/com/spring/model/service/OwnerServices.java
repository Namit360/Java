package com.spring.model.service;
import java.util.List;
import java.util.Optional;
import com.spring.model.Owner;

public interface OwnerServices 
{
	public List<Owner> getStaffDetails();
	public List<Owner> getGuestDetails();
	public List<Owner> getReservationDetails();
	public List<Owner> getInventoryDetails();
	public List<Owner> getRoomDetails();
	public Optional<Owner> getSingleCustomer(String department);
	public List<Owner> fetchAllDepartment();
	void addUser(Owner owner);
	public Object fetchStaff();
	public Object fetchStaffID();
	public String deleteDeptDetailsbyId(int id);
}