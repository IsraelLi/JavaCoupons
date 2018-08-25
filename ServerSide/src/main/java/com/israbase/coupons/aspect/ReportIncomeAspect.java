package com.israbase.coupons.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.israbase.coupons.dao.CustomerDao;
import com.israbase.coupons.entities.Coupon;
import com.israbase.coupons.entities.Income;
import com.israbase.coupons.helpers.IncomeType;
import com.israbase.coupons.services.api.IncomeConnectorService;

@Aspect
@Component
public class ReportIncomeAspect {
	
	@Autowired
	private IncomeConnectorService incomeService;
	
	@Autowired
	private CustomerDao customerDao;
	
	@AfterReturning(pointcut = "@annotation(ReportIncome)", returning = "retVal")
	public void reportIncome(JoinPoint joinPoint, Object retVal) {
		
		ReportIncome reportIncomeAnno = getAnnotation(joinPoint);
		System.err.println(joinPoint.getThis());
		
		switch (reportIncomeAnno.type()) {
			case COMPANY_NEW_COUPON:
				incomeService.sendIncome(new Income(((Coupon)retVal).getCompany().getEmail(), 
						IncomeType.COMPANY_NEW_COUPON, 100.0));
				break;
			case COMPANY_UPDATE_COUPON:
				incomeService.sendIncome(new Income(((Coupon)retVal).getCompany().getEmail(), 
						IncomeType.COMPANY_UPDATE_COUPON, 10.0));
				break;
			case CUSTOMER_PURCHASE:
				incomeService.sendIncome(new Income(customerDao.getById((Long)joinPoint.getArgs()[0]).getEmail(), 
						IncomeType.CUSTOMER_PURCHASE, ((Coupon)retVal).getPrice()));
				break;
			default:
				break;
		}
		
	}
	
	private ReportIncome getAnnotation(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod().getAnnotation(ReportIncome.class);
	}
}
