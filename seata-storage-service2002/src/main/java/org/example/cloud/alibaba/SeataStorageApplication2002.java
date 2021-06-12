package org.example.cloud.alibaba;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:27:13
 */
@EnableAutoDataSourceProxy
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SeataStorageApplication2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication2002.class,args);
    }
}
