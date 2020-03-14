package com.example.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: tanxx
 * @create: 2020-03-14 10:03
 * @description:
 **/
@Service
@Slf4j
public class PaymentService {

    public String hystrixOk() {
        log.info("******* hystrixOk " + Thread.currentThread().getName() + "O(∩_∩)O哈哈~");
        return " hystrixOk ：" + Thread.currentThread().getName() + " O(∩_∩)O哈哈~";
    }

    @SneakyThrows
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String hystrixTimeout(long time) {
        //int error = 1/0;
        Thread.sleep(time * 1000);
        log.info("******* hystrixTimeout " + Thread.currentThread().getName() + "O(∩_∩)O哈哈~" + "时间：" + time +"秒！");
        return "  hystrixTimeout " + Thread.currentThread().getName() + " O(∩_∩)O哈哈~ " + " 时间：" + time +" 秒！";
    }

    public String hystrixTimeoutHandler(long time) {
        log.info("------调用超时，服务降级处理 hystrixTimeoutHandler -------");
        return "线程池： " + Thread.currentThread().getName() + " hystrixTimeoutHandler,系统繁忙，请稍后再试！";
    }

}
