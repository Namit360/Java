package com.spring.model.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.model.Owner;
import com.spring.repository.OwnerRepo;

@Service
public class OwnerServicesImpl implements OwnerServices
{
		
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public void addUser(Owner owner)
	{
		ownerRepo.save(owner);
	}
		
	@Override
	public List<Owner> getStaffDetails() 
	{
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}

	@Override
	public List<Owner> getGuestDetails() 
	{
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}
	
	public List<Owner> getDeptDetails() 
	{
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}

	@Override
	public List<Owner> getReservationDetails() 
	{
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}

	@Override
	public List<Owner> getInventoryDetails() 
	{
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}

	@Override
	public List<Owner> getRoomDetails() 
	{
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}

	@Override
	public Optional<Owner> getSingleCustomer(String department) {
		return null;
	}

	@Override
	public List<Owner> fetchAllDepartment() {
		List<Owner> owner=ownerRepo.findAll();
		return owner;
	}

	@Override
	public String deleteDeptDetailsbyId(int id) 
	{
		ownerRepo.deleteById(id);
		return "removed "+id;
	}

	@Override
	public Object fetchStaff() 
	{
		return restTemplate.getForObject("http://localhost:8989/staff/allUser", Object.class);
	}

	@Override
	public Object fetchStaffID() {
		return restTemplate.getForObject("http://localhost:8989/staff/add/{id}", Object.class);
	}
}