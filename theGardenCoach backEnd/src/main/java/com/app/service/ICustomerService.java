package com.app.service;

import java.util.List;

import com.app.pojos.Customer;


public interface ICustomerService 
{
	void registerCustomer(Customer cust);
	
	List<Customer> allCustomers();
	
	Customer findById(int id);
	
	Customer validate(String email,String pwd);
	
	boolean verifyUserId(String email);
	
	void updateProfile(Customer cust);

}
