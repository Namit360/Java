package com.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.model.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> 
{

}
