package org.example.cloud.alibaba.service;

import org.example.cloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wenqifeng
 * @date 2021/6/8 23:31:30
 */
@FeignClient(value = "seata-account-service", path = "/account")
public interface AccountService {
    /**
     * 减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     * @return result
     */
    @GetMapping(value = "/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
