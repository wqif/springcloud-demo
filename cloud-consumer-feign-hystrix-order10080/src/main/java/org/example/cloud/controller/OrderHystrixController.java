package org.example.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/5/24 23:05:03
 */
@RestController
@RequestMapping("/consumer/payment/hystrix")
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackHandler")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfoSuccessful(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfoSuccessful(id);
    }

    @GetMapping("/timeout/{id}")
    //    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
    //            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    //    })
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfoTimeout(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    private String paymentInfoTimeoutHandler(Integer id) {
        return String.format("线程池：%s paymentInfoTimeoutHandler，系统繁忙请稍后再试！！id：%s", Thread.currentThread().getName(), id);
    }

    private String paymentGlobalFallbackHandler() {
        // 全局默认降级处理方法不可有形参
        return "Global异常处理，请稍后再试！！！";
    }
}
