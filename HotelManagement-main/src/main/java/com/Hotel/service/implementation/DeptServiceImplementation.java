package com.Hotel.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.model.Department;
import com.Hotel.repository.DeptRepository;
import com.Hotel.service.DeptService;
import com.Hotel.exception.DeptNotFoundException;

@Service
public class DeptServiceImplementation implements DeptService{

    @Autowired
    private DeptRepository repo;

    @Override
    public Department saveDept(Department dept) {
       return repo.save(dept);
    }

    @Override
    public List<Department> getAllDept() {
       return repo.findAll();
    }

    @Override
    public Department getDeptById(Long id) {
       Optional<Department> opt = repo.findById(id);
       if(opt.isPresent()) {
           return opt.get();
       } else {
           throw new DeptNotFoundException("Department Not Found or Not Exists!");
       }
    }

    @Override
    public void deleteDeptById(Long id) {
       repo.delete(getDeptById(id)); 
    }

    @Override
    public void updateDept(Department dept) {
       repo.save(dept);
    }

}