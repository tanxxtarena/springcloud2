package com.example.project.config;

import com.alibaba.fastjson.JSON;
import com.example.project.dao.GatewayRouteDao;
import com.example.project.entities.GatewayRoute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tanxx
 * @create: 2020-03-16 10:31
 * @description:
 **/
@Component
@Slf4j
public class GatewayServiceHandler  implements ApplicationEventPublisherAware, CommandLineRunner {

    @Autowired
    private RedisRouteDefinitionRepository routeDefinitionWriter;

    private ApplicationEventPublisher publisher;

    @Autowired
    private GatewayRouteDao gatewayRouteDao;

    @Override
    public void run(String... args) throws Exception {
        loadRouteConfig();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public String loadRouteConfig() {

        //从数据库拿到路由配置
        List<GatewayRoute> gatewayRouteList = gatewayRouteDao.findAll();

        log.info("************ 网关路由配置信息：=======> "+ JSON.toJSONString(gatewayRouteList));

        gatewayRouteList.forEach(gatewayRoute -> {
            RouteDefinition definition = new RouteDefinition();
            Map<String, String> predicateParams = new HashMap<>(8);
            PredicateDefinition predicate = new PredicateDefinition();
            FilterDefinition filterDefinition = new FilterDefinition();
            Map<String, String> filterParams = new HashMap<>(8);

            URI uri = null;
            if(gatewayRoute.getUri().startsWith("http")){
                //http地址
                uri = UriComponentsBuilder.fromHttpUrl(gatewayRoute.getUri()).build().toUri();
            }else{
                //注册中心
                uri = UriComponentsBuilder.fromUriString("lb://"+gatewayRoute.getUri()).build().toUri();
            }

            definition.setId(gatewayRoute.getId().toString());
            // 名称是固定的，spring gateway会根据名称找对应的PredicateFactory
            predicate.setName("Path");
            predicateParams.put("pattern",gatewayRoute.getPredicates());
            predicate.setArgs(predicateParams);

            // 名称是固定的, 路径去前缀
            filterDefinition.setName("StripPrefix");
            filterParams.put("_genkey_0", gatewayRoute.getFilters().toString());
            filterDefinition.setArgs(filterParams);

            definition.setPredicates(Arrays.asList(predicate));
            definition.setFilters(Arrays.asList(filterDefinition));
            definition.setUri(uri);
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        });

        this.publisher.publishEvent(new RefreshRoutesEvent(this));
        return "success";
    }

    public void deleteRoute(String routeId) {
        routeDefinitionWriter.delete(Mono.just(routeId)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

}
