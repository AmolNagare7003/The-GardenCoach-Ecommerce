package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>
{
	Customer findByEmail(String email);
	
}
