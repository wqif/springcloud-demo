package org.example.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenqifeng
 * @date 2021/6/1 11:29:10
 */
@RestController
@RequestMapping("/payment/nacos")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public String getPayment(@PathVariable Long id) {
        return String.format("nacos registry，serverPort：%s，id：%s", serverPort, id);
    }
}
