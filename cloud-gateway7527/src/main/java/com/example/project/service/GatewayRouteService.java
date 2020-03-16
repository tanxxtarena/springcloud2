package com.example.project.service;

import com.example.project.dao.GatewayRouteDao;
import com.example.project.entities.GatewayRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: tanxx
 * @create: 2020-03-16 10:38
 * @description:
 **/
@Service
public class GatewayRouteService {

    @Autowired
    private GatewayRouteDao gatewayRouteMapper;

    public List<GatewayRoute> findAll() {
        return gatewayRouteMapper.findAll();
    }

    public Integer add(GatewayRoute gatewayRoute) {
        gatewayRoute.setCreateDate(new Date());
        gatewayRoute.setCreatorId("");
        return gatewayRouteMapper.insert(gatewayRoute);
    }

    public Integer update(GatewayRoute gatewayRoute) {
        gatewayRoute.setUpdateDate(new Date());
        gatewayRoute.setUpdateId("");
        return gatewayRouteMapper.update(gatewayRoute);
    }

    public Integer delete(String id) {
        return gatewayRouteMapper.delete(Long.parseLong(id));
    }

}
