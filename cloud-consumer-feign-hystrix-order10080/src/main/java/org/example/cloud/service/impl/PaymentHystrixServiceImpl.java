package org.example.cloud.service.impl;

import org.example.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author wenqifeng
 * @date 2021/5/25 23:11:16
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoSuccessful(Integer id) {
        return "----------------> PaymentHystrixServiceImpl fallback paymentInfoSuccessful";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "----------------> PaymentHystrixServiceImpl fallback paymentInfoTimeout";
    }
}
