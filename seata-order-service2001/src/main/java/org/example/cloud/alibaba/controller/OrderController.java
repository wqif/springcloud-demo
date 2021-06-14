package org.example.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.alibaba.domain.CommonResult;
import org.example.cloud.alibaba.domain.Order;
import org.example.cloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/6/8 23:48:20
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return CommonResult.instance(200, "订单创建成功");
    }
    @GetMapping("/snowflake")
    public void getIdBySnowFlake(){
        orderService.getIdBySnowFlake();
    }
}
