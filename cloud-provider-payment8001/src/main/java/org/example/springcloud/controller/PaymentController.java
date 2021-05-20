package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spirngcloud.entities.CommonResult;
import org.example.spirngcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021-05-07 23:12
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        for (String service : discoveryClient.getServices()) {
            log.info("service：{}", service);
        }

        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
            log.info("serviceId：{}\thost：{}\tport：{}\turi：{}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return discoveryClient;
    }


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果:" + result);
        return result > 0 ?
                new CommonResult(0, String.format("success(port:%s)", serverPort), true) :
                new CommonResult(1, String.format("插入失败(port:%s)", serverPort), null);

    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果:" + payment);
        return new CommonResult(0, String.format("success(port:%s)", serverPort), payment);
    }

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
