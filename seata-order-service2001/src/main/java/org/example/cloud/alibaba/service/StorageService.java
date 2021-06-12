package org.example.cloud.alibaba.service;

import org.example.cloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wenqifeng
 * @date 2021/6/8 23:32:02
 */
@FeignClient(value = "seata-storage-service", path = "/storage")
public interface StorageService {
    /**
     * 库存扣减
     *
     * @param productId 产品id
     * @param count     数量
     * @return result
     */
    @GetMapping("/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
