package org.example.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.service.MessageProvider;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wenqifeng
 * @date 2021/5/30 20:08:34
 */
@Slf4j
@Component
public class MessageProviderImpl implements MessageProvider {

    //这里直接装配一个桥 用来连接rabbit或者kafka
    @Resource
    StreamBridge streamBridge;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder.withPayload(serial).build();
        streamBridge.send("send-out-0", message);
        log.info("serial ------------> {}", serial);
        return serial;
    }
}
