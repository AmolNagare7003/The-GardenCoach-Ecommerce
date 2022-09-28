package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.IOrderDetailsDao;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailService{

	@Autowired
	private IOrderDetailsDao oddao;
	
	@Override
	public void saveOrderDetails(OrderDetails od) {
		oddao.save(od);
	}


	@Override
	public Optional<OrderDetails> findById(int id) {
		
		return oddao.findById(id);
	}

	@Override
	public List<OrderDetails> findByOrder(Order order) {
		
		return oddao.findByOrder(order);
	}

}
