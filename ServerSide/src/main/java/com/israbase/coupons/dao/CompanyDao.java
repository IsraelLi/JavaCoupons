package com.israbase.coupons.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israbase.coupons.dao.repository.CompanyRepo;
import com.israbase.coupons.entities.Company;
import com.israbase.coupons.entities.User;
import com.israbase.coupons.helpers.ClientType;
import com.israbase.coupons.helpers.exceptions.EntityNotFoundException;
import com.israbase.coupons.helpers.exceptions.UserNotFoundException;

@Service
public class CompanyDao {
	
	@Autowired
	private CompanyRepo companyRepository;
	
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	public Company save(Company company) {
		return companyRepository.save(company);
	}
	
	public Company getById(Long id) throws EntityNotFoundException {
		return companyRepository.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Company with id " + id + " is not found"));
	}
	
	public Company delete(Long id) throws EntityNotFoundException {
		Company company = getById(id);
		companyRepository.delete(company);
		return company;
	}
	
	public User getCompanyUser(String email, String password) throws UserNotFoundException {
		List<Company> companies = companyRepository.findByEmailAndPassword(email, password);
		if (companies.isEmpty()) {
			throw new UserNotFoundException("Company email or password is incorrect.");
		} else {
			Company company = companies.get(0);
			return new User(company.getId(), company.getName(), company.getEmail(), ClientType.COMPANY);
		}
	}

}
