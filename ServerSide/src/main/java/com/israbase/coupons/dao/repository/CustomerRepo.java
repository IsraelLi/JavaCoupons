package com.israbase.coupons.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.israbase.coupons.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long>{
	
	List<Customer> findAll();
	
	List<Customer> findByEmailAndPassword(String email, String password);
}
