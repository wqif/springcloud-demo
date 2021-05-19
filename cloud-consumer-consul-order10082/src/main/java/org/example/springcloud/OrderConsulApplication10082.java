package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wenqifeng
 * @date 2021/5/19 18:05:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulApplication10082 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication10082.class, args);
    }
}
