package com.Hotel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}