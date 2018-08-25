package com.israbase.coupons.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israbase.coupons.entities.Coupon;
import com.israbase.coupons.helpers.CouponType;
import com.israbase.coupons.services.api.CompanyService;
import com.israbase.coupons.services.api.SystemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController  
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private SystemService systemService;
	
	@PostMapping("/couponCreate")
	public ResponseEntity<Coupon> createCoupon(@Valid @RequestBody Coupon coupon, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).createCoupon(
				coupon, Long.parseLong(request.getParameter("company_id"))));
	}

	@GetMapping("/couponDelete/{id}")
	public ResponseEntity<Coupon> removeCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).removeCoupon(couponId));
	}
	
	@PostMapping("/couponApdate")
	public ResponseEntity<Coupon> updateCoupon(@Valid @RequestBody Coupon coupon, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).updateCoupon(coupon));
	}
	
	@GetMapping("/couponGet/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).getCoupon(couponId));
	}
	
	@GetMapping("/couponsGetAll")
	public ResponseEntity<List<Coupon>> getAllCoupons(HttpServletRequest request) {
		return ResponseEntity.ok().body(
				getCompanyService(request).getAllCoupons(Long.parseLong(request.getParameter("company_id"))));
	}
 
	@GetMapping("/couponGetType")
	public ResponseEntity<List<CouponType>> getCouponTypes(HttpServletRequest request) {
		return ResponseEntity.ok().body(
				getCompanyService(request).getCouponTypes());
	} 
	
	private CompanyService getCompanyService(HttpServletRequest request) {
		return (CompanyService) systemService.getClient(request);
	}
}
