package com.exmaple.project.controller;

import com.exmaple.project.service.PaymentHystrixService;
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
 * @create: 2020-03-14 10:23
 * @description:
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    /**
     * http://localhost/consumer/payment/hystrix/ok
     * @return
     */
    @GetMapping("/payment/hystrix/ok")
    public String hystrixOk() {
        return paymentHystrixService.hystrixOk();
    }

    /**
     * http://localhost/consumer/payment/hystrix/timeout/3
     * 客户端自定义的服务降级处理
     * @param time 秒数
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{time}")
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String hystrixTimeout(@PathVariable("time") long time) {
        log.info("********  {} hystrixTimeout 客户端等待 {} 秒。", Thread.currentThread().getName(), time);
        return paymentHystrixService.hystrixTimeout(time);
    }

    public String hystrixTimeoutHandler(@PathVariable("time") long time) {
        return Thread.currentThread().getName() + " hystrixTimeoutHandler 超过" + time + " s等待，客户端自我保护降级。";
    }
}
