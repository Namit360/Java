package com.Hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hotel.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

	
	
	public Staff findBystaffName(String name);
	
}
