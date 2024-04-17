package com.spring.model.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.model.Inventory;
import com.spring.model.Owner;
import com.spring.repository.OwnerRepo;

@Service
public class OwnerServicesImpl implements OwnerServices
{
		
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	//CRUD Operation
	
	@Override
	public Owner addDept(Owner owner) {
		return ownerRepo.save(owner);
	}

	@Override
	public List<Owner> fetchAlldept() {
		List<Owner> owner = ownerRepo.findAll();
		return owner;
	}

	@Override
	public Optional<Owner> fetchDeptDetailsbyId(int id) {
		return ownerRepo.findById(id);
	}

	@Override
	public String deleteDeptDetailsbyId(int id) {
		ownerRepo.deleteById(id);
		return "dept removed "+id;
	}

	@Override
	public void updateDeptDetails(int id, Owner dept) {
		Owner owner = ownerRepo.findById(id).orElse(null);
		owner.setDeptid(dept.deptid);
		owner.setDeptname(dept.deptname);
		owner.setManagerid(dept.managerid);
		owner.setManagername(dept.managername);
		owner.setStaffavail(dept.staffavail);
		ownerRepo.save(owner);
	}
	
	//RestTemplate Implementation
	@Override
	public Object fetchStaff() 
	{
		return restTemplate.getForObject("http://localhost:8383/staff/allUser", Object.class);
	}

	@Override
	public Object fetchStaffID() {
		return restTemplate.getForObject("http://localhost:8383/staff/add/{id}", Object.class);
	}

	@Override
	public Object fetchInventory() {
		return restTemplate.getForObject("http://localhost:8383/inventory/allInventories", Object.class);
	}

	/*
	 * @Override public Object addStaff(Staff staff) { Staff staff1 = new Staff();
	 * staff1.setStaffId(staff.getStaffId());
	 * staff1.setStaffName(staff.getStaffName());
	 * staff1.setStaffAddress(staff.getStaffAddress());
	 * staff1.setAge(staff.getAge()); staff1.setSalary(staff.getSalary());
	 * staff.setEmail(staff.getEmail()); return
	 * restTemplate.postForObject("http://localhost:8383/staff/fetch",staff,
	 * Staff.class); }
	 */
	
	@Override
    public Object addDetails(Inventory inventory) {
        Inventory inventory1=new Inventory();
        inventory1.setInventoryId(inventory.getInventoryId());
        inventory1.setNo_Of_Blankets(inventory.getNo_Of_Blankets());
        inventory1.setNo_Of_Towels(inventory.getNo_Of_Towels());
        inventory1.setNo_Of_Toiletries(inventory.getNo_Of_Toiletries());
        inventory1.setNo_Of_WaterBottles(inventory.getNo_Of_WaterBottles());
        return restTemplate.postForObject("http://localhost:8383/inventory/Add", inventory,Inventory.class);
    }
	
	@Override
	public Object getBill() {
		return restTemplate.getForObject("http://localhost:1716/bill/getHotelBills", Object.class);
	}

	@Override
	public Object fetchGuest() {
		return restTemplate.getForObject("http://localhost:1716/guest/guestdetails", Object.class);
	}
}