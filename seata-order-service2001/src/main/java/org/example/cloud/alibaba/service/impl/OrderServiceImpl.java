package org.example.cloud.alibaba.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.alibaba.dao.OrderDao;
import org.example.cloud.alibaba.domain.Order;
import org.example.cloud.alibaba.service.AccountService;
import org.example.cloud.alibaba.service.OrderService;
import org.example.cloud.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/6/8 23:26:51
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----> 开始创建订单。。。");
        // 1.新建订单
        orderDao.create(order);

        // 2.扣减库存
        log.info("-----> 订单服务开始调用库存，做库存扣减。。。");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----> 库存数量扣减完成。。。");

        // 3.扣减余额
        log.info("-----> 订单服务调用账户，做余额扣减。。。");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----> 账户余额扣减完成。。。");

        // 4.完成订单，修改订单状态
        log.info("-----> 订单完成，修改订单状态。。。");
        orderDao.update(order.getUserId(), 0);

        log.info("-----> 下单结束。。。");

    }
}
