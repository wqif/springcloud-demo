package org.example.cloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:54:03
 */
public interface AccountService {
    /**
     * 余额扣减
     *
     * @param userId 账户id
     * @param money  扣减数额
     */
    void decrease(Long userId, BigDecimal money);
}
