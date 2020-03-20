package com.example.project.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tanxx
 * @create: 2020-03-20 08:19
 * @description:
 **/
@RestController
@RequestMapping("sentinel")
@Slf4j
public class SentinelController {

    @GetMapping("/test1")
    public String test1() {
        log.info("----------  test1 -----------");
        return "test1";
    }

    @GetMapping("/test2")
    @SneakyThrows
    public String test2() {
        Thread.sleep(1000);
        log.info("----------  test2 -----------");
        return "test2";
    }

}
