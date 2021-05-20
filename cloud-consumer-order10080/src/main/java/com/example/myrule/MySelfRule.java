package com.example.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自spring cloud 2020.0版本之后，netflix移除了ribbon的依赖
 * 若想继续使用可选择降低spring cloud版本，选择临时降版本学习ribbon的使用，后续切换为新版本
 *
 * @author wenqifeng
 * @date 2021/5/19 23:56:27
 */
@Configuration
public class MySelfRule {

    /**
     * 将随机调用负载均衡算法bean交给spring容器管理
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
