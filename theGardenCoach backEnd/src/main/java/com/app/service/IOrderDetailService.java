package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Order;
import com.app.pojos.OrderDetails;



public interface IOrderDetailService {

	void saveOrderDetails(OrderDetails od);
	Optional<OrderDetails> findById(int id);
	List<OrderDetails> findByOrder(Order order);
}
