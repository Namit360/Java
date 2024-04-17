package com.Hotel.service;

import java.util.List;
import com.Hotel.model.Department;

public interface DeptService {

    public Department saveDept(Department dept);
    public List<Department> getAllDept();
    public Department getDeptById(Long id);
    public void deleteDeptById(Long id);
    public void updateDept(Department dept);

}