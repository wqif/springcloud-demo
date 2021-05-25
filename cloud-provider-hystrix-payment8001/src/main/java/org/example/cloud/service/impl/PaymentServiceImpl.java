package org.example.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.cloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author wenqifeng
 * @date 2021/5/22 21:46:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoSuccessful(Integer id) {
        return String.format("线程池：%s paymentInfoSuccessful，id：%s", Thread.currentThread().getName(), id);
    }


    /**
     * 服务报错或超时进行服务降级
     *
     * @param id id
     * @return str
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
//        int x = 10 / 0;
        Integer timeNumber = null;
        try {
            timeNumber = 2;
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException ignore) {

        }
        return String.format("线程池：%s paymentInfoTimeout，id：%s，耗时：%s s", Thread.currentThread().getName(), id, timeNumber);
    }

    private String paymentInfoTimeoutHandler(Integer id) {
        return String.format("线程池：%s paymentInfoTimeoutHandler，系统繁忙请稍后再试！！id：%s", Thread.currentThread().getName(), id);
    }

    // 服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少熔断
    })
    public String paymentCircuitBreaker(@PathVariable Integer id) {

        if (id < 0) {
            throw new RuntimeException("id不能为负数！");
        }
        String simpleUUID = IdUtil.simpleUUID();

        return String.format("%s\t调用成功，流水号：%s", Thread.currentThread().getName(), simpleUUID);
    }

    private String paymentCircuitBreakerFallback(@PathVariable Integer id) {
        return "id不能为负数，请稍后再试！！！";
    }
}
