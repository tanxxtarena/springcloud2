package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: tanxx
 * @create: 2020-03-14 10:02
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
@Slf4j
//开启hystrix功能
@EnableCircuitBreaker
public class ProviderHystrixPaymentApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPaymentApplication8001.class, args);
        log.info("------------ProviderHystrixPaymentApplication8001------------");
    }
}
