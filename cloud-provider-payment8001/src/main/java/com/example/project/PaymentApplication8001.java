package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: tanxx
 * @create: 2020-03-12 09:29
 * @description:
 **/
@SpringBootApplication
@Slf4j
public class PaymentApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8001.class, args);
        log.info("---------- PaymentApplication8001 running -----------");
    }
}
