package org.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wenqifeng
 * @date 2021/5/20 23:43:30
 */
public interface LoadBalancer {
     ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
