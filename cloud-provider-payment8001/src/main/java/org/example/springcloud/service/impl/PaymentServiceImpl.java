package org.example.springcloud.service.impl;

import org.example.springcloud.dao.PaymentDAO;
import org.example.spirngcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021-05-07 23:10
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDAO paymentDAO;

    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
