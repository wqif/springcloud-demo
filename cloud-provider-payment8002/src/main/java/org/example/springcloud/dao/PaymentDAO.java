package org.example.springcloud.dao;

import org.example.spirngcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wenqifeng
 * @date 2021-05-07 22:56
 */
@Mapper
public interface PaymentDAO {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
