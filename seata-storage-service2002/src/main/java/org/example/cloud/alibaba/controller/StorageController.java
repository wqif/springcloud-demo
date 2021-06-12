package org.example.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.alibaba.domain.CommonResult;
import org.example.cloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/6/11 22:34:48
 */
@Slf4j
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     扣减数量
     * @return 结果
     */
    @GetMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        log.info("-------> 扣除库存开始。。。");
        storageService.decrease(productId, count);
        log.info("-------> 扣除库存开始。。。");
        return CommonResult.instance(200, "success");
    }
}
