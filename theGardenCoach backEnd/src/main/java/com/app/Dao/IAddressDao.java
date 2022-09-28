package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;

@Repository
public interface IAddressDao extends JpaRepository<Address, Integer> 
{

}
