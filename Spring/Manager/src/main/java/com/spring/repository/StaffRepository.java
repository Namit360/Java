package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

	
	
	public Staff findBystaffName(String name);
	
}
