package org.example.cloud.alibaba.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wenqifeng
 * @date 2021/6/14 17:23:54
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {
    private long workId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workId, datacenterId);

    @PostConstruct
    public void init() {
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workId：{}", workId);

        } catch (Exception e) {
            log.error("当前机器的workId获取失败，error:" + e.getMessage(), e);
            workId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workId, long datacenterId) {
        return IdUtil.createSnowflake(workId, datacenterId).nextId();
    }
}
