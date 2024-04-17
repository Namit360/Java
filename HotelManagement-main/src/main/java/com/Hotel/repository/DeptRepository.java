package com.Hotel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {

}