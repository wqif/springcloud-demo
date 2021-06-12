package org.example.cloud.alibaba.service;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:31:33
 */
public interface StorageService {
    /**
     * 减库存
     *
     * @param productId 产品id
     * @param count     数量
     */
    void decrease(Long productId, Integer count);
}
