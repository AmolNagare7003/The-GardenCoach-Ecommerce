package com.app.DTO;

import java.util.List;

import com.app.pojos.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO 
{
	private Order order;
	private List<OrderDetailsDTO> details;
	
	

}
