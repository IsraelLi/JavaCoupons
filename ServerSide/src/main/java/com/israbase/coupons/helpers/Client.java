package com.israbase.coupons.helpers;

import com.israbase.coupons.entities.User;
import com.israbase.coupons.helpers.exceptions.UserNotFoundException;

public interface Client {
	
	User login(String name, String password) 
			throws UserNotFoundException;
	
}
