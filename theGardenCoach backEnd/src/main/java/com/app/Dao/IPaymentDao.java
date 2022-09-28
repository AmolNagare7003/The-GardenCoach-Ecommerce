package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Payment;

@Repository
public interface IPaymentDao extends JpaRepository<Payment, Integer>
{

}
