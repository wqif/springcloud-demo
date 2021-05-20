package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wenqifeng
 * @date 2021-05-08 23:12
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderApplication10080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication10080.class, args);
    }
}
