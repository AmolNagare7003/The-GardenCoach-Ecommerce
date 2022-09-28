package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

@Repository
public interface IOrderDetailsDao extends JpaRepository<OrderDetails, Integer>
{
	List<OrderDetails> findByOrder(Order order);

}
