package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.Order;



public interface IOrderService {

	Order saveOrder(Order order);
	List<Order> getAllOrders();
	List<Order> getCustomerOrders(Customer customer);
	Order findById(int id);
}
