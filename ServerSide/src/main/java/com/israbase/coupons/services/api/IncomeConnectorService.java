package com.israbase.coupons.services.api;

import com.israbase.coupons.entities.Income;

public interface IncomeConnectorService {
	
	/**
	 * Establish connection with income registering microservice and post provided income entity
	 * containing all the details about business transaction and it's owner
	 * 
	 * @param income entity to be sent
	 */
	void sendIncome(Income income);

}