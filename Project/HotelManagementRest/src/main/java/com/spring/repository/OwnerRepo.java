package com.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.model.Owner;

@Repository 
public interface OwnerRepo extends JpaRepository<Owner, Integer> 
{
	
}