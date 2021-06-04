package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wenqifeng
 * @date 2021/6/3 23:39:21
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosApplication10084 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication10084.class, args);
    }
}
