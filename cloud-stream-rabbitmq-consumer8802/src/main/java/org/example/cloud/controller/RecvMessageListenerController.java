package org.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author wenqifeng
 * @date 2021/5/30 20:29:24
 */
@Slf4j
@Component
public class RecvMessageListenerController {

    @Value("${server.port}")
    private Integer serverPort;

    @Bean
    public Consumer<Message<String>> recv() {
        return (message) -> log.info("消费者：1，message：{}，serverPort：{}", message.getPayload(), serverPort);
    }
}
