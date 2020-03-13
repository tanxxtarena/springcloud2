package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: tanxx
 * @create: 2020-03-13 09:38
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class PaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class, args);
        log.info("---------- PaymentApplication8002 running -----------");
    }
}
