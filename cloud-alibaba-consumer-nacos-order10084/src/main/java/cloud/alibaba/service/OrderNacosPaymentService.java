package cloud.alibaba.service;

import org.example.spirngcloud.entities.CommonResult;
import org.example.spirngcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wenqifeng
 * @date 2021/6/3 23:35:12
 */
@Service
@FeignClient(value = "nacos-payment-provider", path = "/paymentSQL", contextId = "aaa")
public interface OrderNacosPaymentService {
    @GetMapping("/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}


