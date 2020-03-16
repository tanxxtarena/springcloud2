package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: tanxx
 * @create: 2020-03-16 09:32
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class GateWayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication9527.class, args);
        log.info("----------GateWayApplication9527----------");
    }
}
