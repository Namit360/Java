package com.spring.model.service;
import java.util.List;
import java.util.Optional;
import com.spring.model.Inventory;
import com.spring.model.Owner;

public interface OwnerServices 
{
	public Owner addDept(Owner owner);
	public List<Owner> fetchAlldept();
	public Optional<Owner> fetchDeptDetailsbyId(int id);
	public String deleteDeptDetailsbyId(int id);
	public void updateDeptDetails(int id, Owner dept);
	
	//Rest Template methods 
	public Object fetchStaff();
	public Object fetchStaffID();
	public Object fetchInventory();
	/* public Object addStaff(Object object); */
	public Object getBill();
	Object addDetails(Inventory inventory);
	public Object fetchGuest();
}