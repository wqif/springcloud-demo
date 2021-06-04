package org.example.cloud.alibaba.controller;

import com.google.common.collect.Maps;
import org.example.spirngcloud.entities.CommonResult;
import org.example.spirngcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wenqifeng
 * @date 2021/6/3 23:44:04
 */
@RestController
@RequestMapping("/paymentSQL")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> map = Maps.newHashMap();

    static {
        map.put(1L, new Payment(1L, "aaaaaaaaaaaaaaaaaaaaaaaa"));
        map.put(2L, new Payment(2L, "bbbbbbbbbbbbbbbbbbbbbbbb"));
        map.put(3L, new Payment(3L, "cccccccccccccccccccccccc"));
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id) {
        Payment payment = map.get(id);
        return new CommonResult<>(200, "from mysql, serverPort:" + serverPort, payment);
    }
}
