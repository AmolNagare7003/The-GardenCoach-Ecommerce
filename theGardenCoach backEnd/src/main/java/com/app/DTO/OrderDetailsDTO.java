package com.app.DTO;

import org.springframework.beans.BeanUtils;

import com.app.pojos.OrderDetails;
import com.app.pojos.Product;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailsDTO 
{
	private int id;
	private Product product;
	private int qty;
	
	public static OrderDetailsDTO fromEntity(OrderDetails orderDetails) 
	{
		OrderDetailsDTO dto = new OrderDetailsDTO();
		BeanUtils.copyProperties(orderDetails, dto);		
		return dto;
	
	}

}
