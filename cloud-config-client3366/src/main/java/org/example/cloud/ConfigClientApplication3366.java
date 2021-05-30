package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wenqifeng
 * @date 2021/5/30 15:15:52
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3366.class, args);
    }
}
