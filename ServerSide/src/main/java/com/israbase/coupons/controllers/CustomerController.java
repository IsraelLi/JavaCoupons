package com.israbase.coupons.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israbase.coupons.entities.Coupon;
import com.israbase.coupons.services.api.CustomerService;
import com.israbase.coupons.services.api.SystemService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/couponPurchase/{id}")
	public ResponseEntity<Coupon> purchaseCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
			return ResponseEntity.ok().body( 
					getCustomerService(request).purchaseCoupon(Long.parseLong(request.getParameter("customer_id")), couponId));
	}
	
	@GetMapping("/couponsGet/{id}")
	public ResponseEntity<List<Coupon>> getPurchasedCoupons(@PathVariable("id") Long customerId,
				HttpServletRequest request) {
			return ResponseEntity.ok().body(
					getCustomerService(request).getAllPurchasedCoupons(customerId));
	}
	
	@GetMapping("/couponsGetAll")
	public ResponseEntity<List<Coupon>> getAllCoupons(HttpServletRequest request) {
		return ResponseEntity.ok().body(getCustomerService(request).getAllCoupons());
	}
	
	private CustomerService getCustomerService(HttpServletRequest request) {
		return (CustomerService) systemService.getClient(request);
	}
}
