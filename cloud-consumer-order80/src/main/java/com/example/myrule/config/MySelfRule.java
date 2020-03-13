package com.example.myrule.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: tanxx
 * @create: 2020-03-13 10:21
 * @description:
 **/
@Configuration
public class MySelfRule {

    /**
     * 修改Ribbon默认的轮询算法
     * 1、配置文件不能和@ComponentScan标签扫描的包在同一个包或者子包下
     * 2、启动类要配置@RibbonClient(name = "要调用的服务名", configuration=MySelfRule.class)
     * @return
     */
    @Bean
    public RandomRule randomRule() {
        return new RandomRule();
    }

    /**
     * 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后rest接口计数从1开始。
     */
}
