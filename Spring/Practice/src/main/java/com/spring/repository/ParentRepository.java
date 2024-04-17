package com.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spring.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> 
{
	
}