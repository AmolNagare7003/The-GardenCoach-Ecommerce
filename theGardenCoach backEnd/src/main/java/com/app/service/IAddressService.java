package com.app.service;

import com.app.pojos.Address;

public interface IAddressService {

	Address saveAddress(Address address);
	Address findAddress(int id);
	
}
