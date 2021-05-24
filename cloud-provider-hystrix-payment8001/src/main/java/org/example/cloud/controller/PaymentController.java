package org.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/5/22 21:52:36
 */
@Slf4j
@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String paymentInfoSuccessful(@PathVariable Integer id) {
        String result = paymentService.paymentInfoSuccessful(id);
        log.info("------------------> result：" + result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("------------------> result：" + result);
        return result;
    }
}
