package org.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手动实现轮询负载均衡
 *
 * @author wenqifeng
 * @date 2021/5/20 23:45:55
 */
@Component
public class CustomRoundRobinLoadBalancer implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {

        while (true) {
            int current = atomicInteger.get();
            int next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                System.out.println("------> 第" + next + "访问！");
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
