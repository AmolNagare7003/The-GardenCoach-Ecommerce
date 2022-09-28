package com.app.DTO;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Payment;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlaceOrderDTO 
{
	
	private Address address;
	private List<CartDTO> cart;
	private Payment payment;
	private int customerid;


}
