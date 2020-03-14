package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author: tanxx
 * @create: 2020-03-14 09:03
 * @description: 测试 http://localhost/consumer/payment/feign/get/1
 **/
@SpringBootApplication
@Slf4j
@EnableFeignClients
public class ConsumerFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication80.class, args);
        log.info("------------ConsumerFeignApplication80-----------");
    }
}
