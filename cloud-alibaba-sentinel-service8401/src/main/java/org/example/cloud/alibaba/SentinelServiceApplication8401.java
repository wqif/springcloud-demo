package org.example.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wenqifeng
 * @date 2021/6/1 21:16:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication8401.class, args);
    }
}
