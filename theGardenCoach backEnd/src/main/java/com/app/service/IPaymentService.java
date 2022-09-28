package com.app.service;

import java.util.Optional;

import com.app.pojos.Payment;

public interface IPaymentService 
{

	Payment savePayment(Payment payment);
	Optional<Payment> findPaymentById(int id);
}
