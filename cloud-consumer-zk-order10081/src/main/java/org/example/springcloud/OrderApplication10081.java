package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author wenqifeng
 * @date 2021-05-08 23:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication10081 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication10081.class, args);
    }
}
