package org.example.cloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wenqifeng
 * @date 2021/6/1 12:16:59
 */
@Service
@FeignClient(value = "nacos-payment-provider", path = "/payment/nacos", contextId = "aaa")
public interface OrderNacosPaymentService {
    @GetMapping("/{id}")
    String getPayment(@PathVariable("id") Long id);
}


