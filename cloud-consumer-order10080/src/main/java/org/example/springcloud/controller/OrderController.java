package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spirngcloud.entities.CommonResult;
import org.example.spirngcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021-05-08 23:13
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URI = "http://127.0.0.1:8001";
    public static final String PAYMENT_URI = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        String url = String.format("%s/payment/create", PAYMENT_URI);
        return restTemplate.postForObject(url, payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        String url = String.format("%s/payment/get/%s", PAYMENT_URI, id);
        return restTemplate.getForObject(url, CommonResult.class);
    }
}
