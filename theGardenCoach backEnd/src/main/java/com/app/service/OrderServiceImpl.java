package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.IOrderDao;
import com.app.pojos.Customer;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao odao;
	
	@Override
	public Order saveOrder(Order order) {
		
		return odao.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return odao.findAll();
	}

	@Override
	public List<Order> getCustomerOrders(Customer customer) {
		
		return odao.findByCustomer(customer);
	}

	
	@Override
	public Order findById(int id) {
		
		return odao.getReferenceById(id);
	}

}
