package com.israbase.coupons.dao.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.israbase.coupons.entities.Coupon;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long>{
	
	List<Coupon> findAll();
	
	@Query("SELECT c from Coupon c where c.endDate < :date")
	List<Coupon> getExpiredFrom(@Param("date") LocalDate date);
	
}
