package org.example.cloud.alibaba.service.impl;

import org.example.cloud.alibaba.dao.StorageDao;
import org.example.cloud.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:31:48
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }

}
