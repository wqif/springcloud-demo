package org.example.cloud.alibaba.service;

import org.example.cloud.alibaba.domain.Order;

/**
 * @author wenqifeng
 * @date 2021/6/8 23:25:33
 */
public interface OrderService {
    void create(Order order);

    String getIdBySnowFlake();
}
