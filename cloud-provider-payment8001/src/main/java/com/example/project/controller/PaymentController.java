package com.example.project.controller;

import com.example.project.entities.CommonResult;
import com.example.project.entities.Payment;
import com.example.project.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: tanxx
 * @create: 2020-03-12 09:52
 * @description:
 **/
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult create(Payment payment) {
        log.info("---- create {}", payment);
        int result = paymentService.create(payment);
        if (result > 0) {
            return CommonResult.ok("插入数据库成功！", result);
        }
        return CommonResult.error("插入数据库失败！");
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        log.info("---- 查询条件 {}", id);
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return CommonResult.ok("查询成功", payment);
        } else {
            return CommonResult.error("没有对应的记录");
        }
    }

}
