package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
public class OrderConsulController {
    public static final String INVOKE_URI = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        String url = String.format("%s/payment/consul", INVOKE_URI);
        return restTemplate.getForObject(url, String.class);
    }
}
