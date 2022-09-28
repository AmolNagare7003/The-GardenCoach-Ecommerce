package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;
import com.app.pojos.Seller;

import org.springframework.data.domain.Sort;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer>{

	List<Product> findBySeller(Seller sellerId,Sort sort);
	List<Product> findByPcat(String pcat,Sort sort);
}

