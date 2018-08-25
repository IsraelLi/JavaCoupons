package com.israbase.coupons.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israbase.coupons.entities.User;
import com.israbase.coupons.helpers.Client;
import com.israbase.coupons.helpers.ClientType;
import com.israbase.coupons.helpers.exceptions.SessionNotFoundException;
import com.israbase.coupons.services.api.AdminService;
import com.israbase.coupons.services.api.CompanyService;
import com.israbase.coupons.services.api.CustomerService;
import com.israbase.coupons.services.api.SystemService;

@Service
public class SystemServiceImpl implements SystemService {
	
	private final Map<ClientType, Client> clients = new HashMap<>();
	
	private final Map<String, HttpSession> sessionsMap = new HashMap<>();
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CustomerService customerService;
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.SystemService#login(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public User login(HttpServletRequest request) {
		ClientType type = ClientType.valueOf(request.getParameter("client-type"));
		User user = clients.get(type).login(
				request.getParameter("email"), request.getParameter("password"));
		request.getSession().invalidate();
		HttpSession session = request.getSession();
		session.setAttribute("client-type", type);
		sessionsMap.put(session.getId(), session);
		
		System.err.println("User " + type + " " + request.getParameter("email") + " logged in.");
		return user;
	} 
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.SystemService#getClient(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public Client getClient(HttpServletRequest request) throws SessionNotFoundException {
		HttpSession session = request.getSession(false);
		if (session == null || sessionsMap.get(session.getId()) == null) 
			throw new SessionNotFoundException(
					"Session expired or session token invalid. Please login again. Please.");
		ClientType type = (ClientType) session.getAttribute("client-type");
		return clients.get(type);
	}
	
	@Override
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "ok";
	}
	
	@PostConstruct
	private void collectServices() {
		clients.put(ClientType.ADMIN, adminService);
		clients.put(ClientType.COMPANY, companyService);
		clients.put(ClientType.CUSTOMER, customerService);
	}

	
}
	