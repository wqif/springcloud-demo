package org.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wenqifeng
 * @date 2021/5/30 15:15:52
 */
@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return String.format("serverPort：%s\t\n\nconfigInfo：%s", serverPort, configInfo);
    }

}
