package com.example.project.service.impl;

import com.example.project.dao.PaymentDao;
import com.example.project.entities.Payment;
import com.example.project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: tanxx
 * @create: 2020-03-12 09:49
 * @description:
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
