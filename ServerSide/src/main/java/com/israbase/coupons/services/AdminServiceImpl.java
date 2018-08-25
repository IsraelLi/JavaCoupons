package com.israbase.coupons.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israbase.coupons.dao.CompanyDao;
import com.israbase.coupons.dao.CustomerDao;
import com.israbase.coupons.entities.Company;
import com.israbase.coupons.entities.Customer;
import com.israbase.coupons.entities.User;
import com.israbase.coupons.helpers.ClientType;
import com.israbase.coupons.helpers.exceptions.EntityNotFoundException;
import com.israbase.coupons.helpers.exceptions.UserNotFoundException;
import com.israbase.coupons.services.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public User login(String email, String password) 
		throws UserNotFoundException {
		if (!email.equals("manager") || !password.equals("AaPassword%"))
			throw new UserNotFoundException("Admin username or password incorrect.");
		return new User(1L, "Admin", "admin@mail.com", ClientType.ADMIN);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#createCompany(com.derzhavets.kuponim.entities.Company)
	 */
	@Override
	public Company saveCompany(Company company) {
		return companyDao.save(company);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#removeCompany(java.lang.Long)
	 */
	@Override
	public Company removeCompany(Long id) throws EntityNotFoundException {
		return companyDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getCompany(java.lang.Long)
	 */
	@Override
	public Company getCompany(Long id) throws EntityNotFoundException {
		return companyDao.getById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getAllCompanies()
	 */
	@Override
	public List<Company> getAllCompanies() {
		return companyDao.getAll();
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#createCustomer(com.derzhavets.kuponim.entities.Customer)
	 */
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#removeCustomer(java.lang.Long)
	 */
	@Override
	public Customer removeCustomer(Long id) throws EntityNotFoundException {
		return customerDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getCustomer(java.lang.Long)
	 */
	@Override
	public Customer getCustomer(Long id) throws EntityNotFoundException {
		return customerDao.getById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAll();
	}

}
