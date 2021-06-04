package cloud.alibaba.controller;

import cloud.alibaba.service.OrderNacosPaymentService;
import cn.hutool.core.lang.Assert;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.example.spirngcloud.entities.CommonResult;
import org.example.spirngcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/6/3 23:34:23
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class CircleBreakerController {

    @Resource
    private OrderNacosPaymentService orderNacosPaymentService;

    @GetMapping("/fallback/{id}")
    //    @SentinelResource("fallback")
    //    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    //    @SentinelResource(value = "fallback", blockHandler = "blockFallback")
    //    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockFallback")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockFallback", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = orderNacosPaymentService.paymentSQL(id);
        Assert.isFalse(id == 4, "非法参数异常...");
        if (null == result.getData()) {
            throw new NullPointerException("没有该id的记录。。。");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult<>(444, "fallback兜底异常处理，error：" + e.getMessage(), new Payment(id, "null"));
    }

    public CommonResult<Payment> blockFallback(@PathVariable Long id, BlockException e) {
        return new CommonResult<>(445, "blockHandler异常处理，error：" + e.getMessage(), new Payment(id, "null"));
    }

}
