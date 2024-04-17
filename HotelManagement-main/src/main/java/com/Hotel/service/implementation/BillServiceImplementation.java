package com.Hotel.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.model.Bill;
import com.Hotel.repository.BillRepository;
import com.Hotel.service.BillService;
import com.Hotel.exception.BillNotFoundException;

@Service
public class BillServiceImplementation implements BillService{

    @Autowired
    private BillRepository repo;

    @Override
    public Bill saveBill(Bill bill) {
       return repo.save(bill);
    }

    @Override
    public List<Bill> getAllBill() {
       return repo.findAll();
    }

    @Override
    public Bill getBillById(Long id) {
       Optional<Bill> opt = repo.findById(id);
       if(opt.isPresent()) {
           return opt.get();
       } else {
           throw new BillNotFoundException("Bill Not Found or Not Exists!");
       }
    }

    @Override
    public void deleteBillById(Long id) {
       repo.delete(getBillById(id)); 
    }

    @Override
    public void updateBill(Bill bill) {
       repo.save(bill);
    }

}