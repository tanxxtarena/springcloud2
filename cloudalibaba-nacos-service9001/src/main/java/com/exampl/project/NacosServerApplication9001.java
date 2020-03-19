package com.exampl.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: tanxx
 * @create: 2020-03-19 10:59
 * @description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NacosServerApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosServerApplication9001.class, args);
        log.info("----------- NacosServerApplication9001 -----------");
    }
}
