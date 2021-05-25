package org.example.cloud.service;

/**
 * @author wenqifeng
 * @date 2021/5/22 21:46:21
 */
public interface PaymentService {
    String paymentInfoSuccessful(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
