package org.example.cloud.alibaba.service.impl;

import org.example.cloud.alibaba.dao.AccountDao;
import org.example.cloud.alibaba.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:54:20
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId, money);
    }
}
