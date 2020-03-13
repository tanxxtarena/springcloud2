package com.example.project.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: tanxx
 * @create: 2020-03-12 10:41
 * @description: 测试url http://localhost/consumer/payment/get/1
 **/
@Configuration
public class RestTemplateConfig {

    /**
     * 当使用了@LoadBalanced注解时，RestTemplate必须使用服务器去调用，不能使用之前的IP地址调用服务
     * Ribbon默认的是轮询算法
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
