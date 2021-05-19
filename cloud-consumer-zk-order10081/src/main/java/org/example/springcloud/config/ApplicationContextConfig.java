package org.example.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wenqifeng
 * @date 2021-05-08 23:18
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    /**
     * 赋予RestTemplate负载均衡的能力
     */
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
