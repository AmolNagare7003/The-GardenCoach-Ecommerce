package com.app.service;

import java.util.List;

import com.app.pojos.Seller;



public interface ISellerService 
{

	void registerSeller(Seller seller);
	List<Seller> allSellers();
	Seller findById(int id);
	Seller validate(String email,String pwd);
	void deleteSeller(int id);
}
