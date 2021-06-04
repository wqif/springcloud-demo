package org.example.cloud.alibaba;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.spirngcloud.entities.CommonResult;

/**
 * @author wenqifeng
 * @date 2021/6/3 23:15:46
 */
public class CustomerBlockHandle {
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(444,"全局异常处理 ---------------> 1");
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"全局异常处理 ---------------> 2");
    }
}
