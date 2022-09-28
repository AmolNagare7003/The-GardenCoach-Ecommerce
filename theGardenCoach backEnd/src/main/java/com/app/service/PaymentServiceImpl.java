package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.IPaymentDao;
import com.app.pojos.Payment;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService
{
	@Autowired
	private IPaymentDao pdao;

	@Override
	public Payment savePayment(Payment payment) {
		
		return pdao.save(payment);
	}

	@Override
	public Optional<Payment> findPaymentById(int id) {
		
		return pdao.findById(id);
	}

}
