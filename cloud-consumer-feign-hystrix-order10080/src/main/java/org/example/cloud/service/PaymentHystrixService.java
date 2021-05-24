package org.example.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wenqifeng
 * @date 2021/5/24 23:02:08
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",path = "/payment/hystrix")
public interface PaymentHystrixService {
    @GetMapping("/ok/{id}")
    String paymentInfoSuccessful(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);
}
