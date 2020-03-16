package com.exmaple.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 当使用了全局的处理之后，定义在类上的降级回调则不生效
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentHystrixFallbackServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok")
    String hystrixOk();

    @GetMapping("/payment/hystrix/timeout/{time}")
    String hystrixTimeout(@PathVariable("time") long time);

}
