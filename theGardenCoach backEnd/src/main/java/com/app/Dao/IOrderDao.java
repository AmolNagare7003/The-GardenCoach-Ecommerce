package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Order;

@Repository
public interface IOrderDao extends JpaRepository<Order, Integer>
{
	List<Order> findByCustomer(Customer customer);
	
}
