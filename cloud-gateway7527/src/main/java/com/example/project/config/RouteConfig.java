package com.example.project.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: tanxx
 * @create: 2020-03-16 10:18
 * @description: 通过代码方式添加路由
 **/
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator addLocator(RouteLocatorBuilder builder) {
        //这里可以配置路由
        return null;
    }
}

