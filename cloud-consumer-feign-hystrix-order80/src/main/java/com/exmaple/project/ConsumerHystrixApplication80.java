package com.exmaple.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: tanxx
 * @create: 2020-03-14 10:19
 * @description:
 **/
@SpringBootApplication
@Slf4j
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixApplication80.class, args);
        log.info("-----------ConsumerHystrixApplication80-----------");
    }
}
