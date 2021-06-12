package org.example.cloud.alibaba;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wenqifeng
 * @date 2021/6/9 00:05:27
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
/**
 * seata1.0后无需手动配置数据源代理  只需引入@EnableAutoDataSourceProxy注解即可
 */
@EnableAutoDataSourceProxy
public class SeataOrderApplication2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication2001.class, args);
    }
}
