package org.example.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.alibaba.domain.CommonResult;
import org.example.cloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:40:37
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @GetMapping("/decrease")
    public CommonResult decrease(Long userId, BigDecimal money) {
        log.info("-------> 扣除余额开始。。。");
//        int x=1/0;
//        // 模拟超时异常，全局事务回滚
//        try {
//            TimeUnit.SECONDS.sleep(6);
//        } catch (Exception ignore) {
//
//        }
        accountService.decrease(userId, money);
        log.info("-------> 扣除余额结束。。。");
        return CommonResult.instance(200, "success");
    }
}
