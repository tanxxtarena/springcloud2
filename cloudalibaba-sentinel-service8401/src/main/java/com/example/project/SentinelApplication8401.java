package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: tanxx
 * @create: 2020-03-20 08:18
 * @description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SentinelApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication8401.class, args);
        log.info("********** SentinelApplication8401 **********");
    }
}
