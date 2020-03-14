package com.exmaple.project.service;

import org.springframework.stereotype.Component;

/**
 * @author: tanxx
 * @create: 2020-03-14 13:44
 * @description: 统一的服务降级处理类
 **/
@Component
public class PaymentHystrixFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String hystrixOk() {
        return Thread.currentThread().getName() + "  PaymentHystrixFallbackService hystrixOk";
    }

    @Override
    public String hystrixTimeout(long time) {
        return Thread.currentThread().getName() + " hystrixTimeoutHandler 超过" + time + " s等待，客户端自我保护降级。";
    }
}
