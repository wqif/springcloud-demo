package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wenqifeng
 * @date 2021/5/22 10:54:49
 */
@EnableFeignClients
@SpringBootApplication
public class OrderFeignApplication10083 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication10083.class, args);
    }
}
