package com.exampl.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tanxx
 * @create: 2020-03-19 11:00
 * @description:
 **/
@RestController
@RequestMapping("/config")
@RefreshScope //当配置文件有修改时，自动刷新配置文件的值
@Slf4j
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping
    public String getInfo() {
        log.info("----------- ConfigController getInfo {}", info);
        return info;
    }
}
