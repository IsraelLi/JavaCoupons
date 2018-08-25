package com.israbase.coupons.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.israbase.coupons.entities.Company;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Long>{
	
	
	List<Company> findAll();
	
	List<Company> findByEmailAndPassword(String email, String pass);
}
