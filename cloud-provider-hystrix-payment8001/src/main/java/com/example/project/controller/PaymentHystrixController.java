package com.example.project.controller;

import cn.hutool.core.util.IdUtil;
import com.example.project.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tanxx
 * @create: 2020-03-14 10:08
 * @description:
 **/
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentHystrixController {

    @Autowired
    private PaymentService paymentService;

    /**
     * http://localhost:8001/payment/hystrix/ok
     * @return
     */
    @GetMapping("/hystrix/ok")
    public String hystrixOk() {
        return paymentService.hystrixOk();
    }

    /**
     * http://localhost:8001/payment/hystrix/timeout/3
     * @param time
     * @return
     */
    @GetMapping("/hystrix/timeout/{time}")
    public String hystrixTimeout(@PathVariable("time") long time) {
        return paymentService.hystrixTimeout(time);
    }

    /**服务熔断*/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    @GetMapping("/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("***** id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数,请稍后重试哭o(╥﹏╥)o id:" + id;
    }
}
