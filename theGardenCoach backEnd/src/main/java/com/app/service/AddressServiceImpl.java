package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.IAddressDao;
import com.app.pojos.Address;

@Service
public class AddressServiceImpl implements IAddressService
{
	@Autowired
	private IAddressDao adao;

	@Override
	public Address saveAddress(Address address) {
		
		return adao.save(address);
	}

	@Override
	public Address findAddress(int id) {
		
		return adao.getReferenceById(id);
		
		
	}

}
