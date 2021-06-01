package org.example.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.alibaba.service.OrderNacosPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/6/1 12:01:46
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment/nacos")
public class OrderNacosController {

    @Resource
    private OrderNacosPaymentService orderNacosPaymentService;

    @GetMapping("/{id}")
    public String paymentInfo(@PathVariable Long id) {
        return orderNacosPaymentService.getPayment(id);
    }

}
