package com.israbase.coupons.dao;

import java.util.List;

import com.israbase.coupons.dao.repository.CustomerRepo;
import com.israbase.coupons.entities.Customer;
import com.israbase.coupons.entities.User;
import com.israbase.coupons.helpers.ClientType;
import com.israbase.coupons.helpers.exceptions.EntityNotFoundException;
import com.israbase.coupons.helpers.exceptions.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDao {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}
	
	public Customer getById(Long id) throws EntityNotFoundException {
		return customerRepo.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Customer with id " + id + " is not found."));
	}
	
	public Customer save(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer delete(Long id) throws EntityNotFoundException {
		Customer customer = getById(id);
		customerRepo.delete(customer);
		return customer;
	}

	public User getCustomerUser(String email, String password) throws UserNotFoundException {
		List<Customer> customers = customerRepo.findByEmailAndPassword(email, password);
		if (customers.isEmpty()) {
			throw new UserNotFoundException("Customer email or password incorrect");
		} else {
			Customer customer = customers.get(0);
			return new User(customer.getId(), customer.getName(), customer.getEmail(), ClientType.CUSTOMER);
		}
	}
}
