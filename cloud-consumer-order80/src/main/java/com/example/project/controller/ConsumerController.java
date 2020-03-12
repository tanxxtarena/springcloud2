package com.example.project.controller;

import com.example.project.entities.CommonResult;
import com.example.project.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: tanxx
 * @create: 2020-03-12 10:40
 * @description: 客户端调用接口
 **/
@RequestMapping("consumer")
@Slf4j
@RestController
public class ConsumerController {

    private static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("-----客户端消息远程服务 {}-----", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/crate", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
