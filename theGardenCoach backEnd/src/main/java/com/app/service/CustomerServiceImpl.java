package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.ICustomerDao;
import com.app.pojos.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao cdao;

	@Override
	public void registerCustomer(Customer cust) {
		
		cdao.save(cust);
		
	}

	@Override
	public List<Customer> allCustomers() {
		
		return cdao.findAll();
	}

	@Override
	public Customer findById(int id) {
		
		return cdao.getReferenceById(id);
	}

	@Override
	public Customer validate(String email, String pwd) {
		Customer cust = cdao.findByEmail(email);
		if(cust != null && cust.getPwd().equals(pwd))
		{
			return cust;
		}
		return null;
	}

	@Override
	public boolean verifyUserId(String email) {
		
		return cdao.findByEmail(email) != null;
	}

	@Override
	public void updateProfile(Customer cust)
	{
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		
	}
		cdao.save(cust);

}
}
