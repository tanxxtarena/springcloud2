package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: tanxx
 * @create: 2020-03-13 09:00
 * @description: http://localhost:7002
 **/
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServerApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7002.class, args);
        log.info("---------------EurekaServerApplication7002--------------");
    }
}
