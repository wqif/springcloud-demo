package org.example.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wenqifeng
 * @date 2021/6/3 23:43:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9003.class, args);
    }
}
