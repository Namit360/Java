package com.spring.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.DAO.CustomerDAO;
import com.spring.model.CustomerModel;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public void addCustomer(CustomerModel customer) {
		customerDAO.save(customer);
	}

	@Transactional
	public void updateCustomer(CustomerModel customer) {
		customerDAO.update(customer);
	}

	@Transactional
	public void deleteCustomer(CustomerModel customer) {
		customerDAO.delete(customer);
	}
	
	@Transactional
	public List<CustomerModel> fetchCustomer() {
		return customerDAO.fetchCustomer();
	}
}

