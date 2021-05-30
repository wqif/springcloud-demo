package org.example.cloud.controller;

import org.example.cloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wenqifeng
 * @date 2021/5/30 20:08:36
 */
@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProviderImpl;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProviderImpl.send();
    }
}
