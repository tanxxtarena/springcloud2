package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: tanxx
 * @create: 2020-03-12 10:37
 * @description: 客户端启动类
 **/
@SpringBootApplication
@Slf4j
public class ConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication80.class, args);
        log.info("------- ConsumerApplication -------");
    }
}
