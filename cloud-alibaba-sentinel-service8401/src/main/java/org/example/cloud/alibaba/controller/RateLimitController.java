package org.example.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.cloud.alibaba.CustomerBlockHandle;
import org.example.spirngcloud.entities.CommonResult;
import org.example.spirngcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenqifeng
 * @date 2021/6/3 22:57:54
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试", new Payment(1L, "0001"));
    }

    public CommonResult handleException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按byUrl限流测试", new Payment(2021L, "0002"));
    }

    @GetMapping(value = "/rateLimit/customerBlockHandle")
    @SentinelResource(value = "customerBlockHandle",
            blockHandlerClass = CustomerBlockHandle.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandle() {
        return new CommonResult(200, "按客户自定义限流测试", new Payment(2021L, "0003"));
    }


}
