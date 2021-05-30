package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wenqifeng
 * @date 2021/5/30 17:05:59
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StreamMqApplication8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqApplication8801.class, args);
    }
}
