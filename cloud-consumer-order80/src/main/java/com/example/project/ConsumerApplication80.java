package com.example.project;

import com.example.myrule.config.MySelfRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: tanxx
 * @create: 2020-03-12 10:37
 * @description: 客户端启动类
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration=MySelfRule.class)
@Slf4j
public class ConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication80.class, args);
        log.info("------- ConsumerApplication -------");
    }
}
