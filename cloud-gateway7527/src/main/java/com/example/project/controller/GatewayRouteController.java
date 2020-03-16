package com.example.project.controller;

import com.example.project.config.GatewayServiceHandler;
import com.example.project.entities.GatewayRoute;
import com.example.project.service.GatewayRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: tanxx
 * @create: 2020-03-16 10:41
 * @description:
 **/
@RestController
@RequestMapping("/route")
@Slf4j
public class GatewayRouteController {

    @Autowired
    private GatewayServiceHandler gatewayServiceHandler;

    @Autowired
    private GatewayRouteService gatewayRouteService;

    @GetMapping("/get")
    public List<GatewayRoute> get() {
        return this.gatewayRouteService.findAll();
    }

    /**
     * 刷新路由配置
     *
     * @return
     */
    @GetMapping("/refresh")
    public String refresh() throws Exception {
        log.info("*************** 网关路由手动刷新 ******************");
        return this.gatewayServiceHandler.loadRouteConfig();
    }

    /**
     * 增加路由记录
     *
     * @return
     */
    @PostMapping("/add")
    public String add(@RequestBody GatewayRoute gatewayRoute) throws Exception {
        gatewayRouteService.add(gatewayRoute);
        gatewayServiceHandler.loadRouteConfig();
        log.info("*************** 网关路由添加成功 ******************");
        return "success";
    }

    @PostMapping("/update")
    public String update(@RequestBody GatewayRoute gategwayRoute) throws Exception {
        gatewayRouteService.update(gategwayRoute);
        gatewayServiceHandler.loadRouteConfig();
        log.info("*************** 网关路由更新成功 ******************");
        return "success";
    }

    @GetMapping("/delete")
    public String delete(@PathVariable String id) throws Exception {
        gatewayRouteService.delete(id);
        gatewayServiceHandler.deleteRoute(id);
        log.info("*************** 网关路由删除成功 ******************");
        return "success";
    }

}
