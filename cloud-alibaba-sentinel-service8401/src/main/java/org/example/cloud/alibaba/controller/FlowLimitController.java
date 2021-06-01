package org.example.cloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenqifeng
 * @date 2021/6/1 21:17:30
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA()  {
        return "--------------> testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--------------> testB";
    }
}
