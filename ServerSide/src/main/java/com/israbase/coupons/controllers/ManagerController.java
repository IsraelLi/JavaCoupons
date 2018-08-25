package com.israbase.coupons.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israbase.coupons.entities.Company;
import com.israbase.coupons.entities.Customer;
import com.israbase.coupons.services.api.AdminService;
import com.israbase.coupons.services.api.SystemService;

@RestController
@RequestMapping("/manager")
public class ManagerController { 
	
	@Autowired
	private SystemService systemService;
	
	@PostMapping("/companySave")
	public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).saveCompany(company));
	}

	@GetMapping("/companyDelete/{id}")
	public ResponseEntity<Company> removeCompany(@PathVariable("id") Long companyId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).removeCompany(companyId));
	}
	
	@GetMapping("/companyGet/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long companyId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getCompany(companyId));
	}
	
	@GetMapping("/companiesGetAll")
	public ResponseEntity<List<Company>> getAllCompanies(HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getAllCompanies());
	}
	
	@PostMapping("/customerSave")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).saveCustomer(customer));
	}
	
	@GetMapping("/customerDelete/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Long customerId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).removeCustomer(customerId));
	}

	@GetMapping("/customerGet/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getCustomer(customerId));
	}
	
	@GetMapping("/customersGetAll")
	public ResponseEntity<List<Customer>> getAllCustomers(HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getAllCustomers());
	}
	
	private AdminService getAdminService(HttpServletRequest request) {
		return (AdminService) systemService.getClient(request);
	}
}
