package org.example.springcloud.service;

import org.example.spirngcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wenqifeng
 * @date 2021-05-07 23:09
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
