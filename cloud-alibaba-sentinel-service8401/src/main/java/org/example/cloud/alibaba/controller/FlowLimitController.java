package org.example.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenqifeng
 * @date 2021/6/1 21:17:30
 */
@Slf4j
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "--------------> testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--------------> testB";
    }

    @GetMapping("/testD")
    public String testD() {
        int age = 10 / 0;
        log.info("--------------> testD");
        return "--------------> testD";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(required = false) String p1, @RequestParam(required = false) String p2) {
        int x= 10/0;
        log.info("--------------> testHotkey");
        return "--------------> testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception) {
        return "-------------------------> deal_testHotkey";
    }

}
