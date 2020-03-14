package com.example.project.controller;

import com.example.project.entities.CommonResult;
import com.example.project.entities.Payment;
import com.example.project.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tanxx
 * @create: 2020-03-14 09:06
 * @description:
 **/
@RestController
@Slf4j
@RequestMapping("consumer")
public class ConsumerFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    /**
     *  http://localhost/consumer/payment/feign/get/1
     * @param id
     * @return
     */
    @GetMapping("/payment/feign/get/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id){
        log.info("-----------Feign running {} ----------", id);
        return paymentFeignService.get(id);
    }

}
