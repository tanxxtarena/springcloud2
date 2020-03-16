package com.example.project.dao;

import com.example.project.entities.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: tanxx
 * @create: 2020-03-16 10:34
 * @description:
 **/
@Mapper
public interface GatewayRouteDao {

    /**
     * 查询所有路由信息
     * @return
     */
    List<GatewayRoute> findAll();

    /**
     * 新增路由信息
     * @param gatewayRoute
     * @return
     */
    int insert(GatewayRoute gatewayRoute);

    /**
     * 更新路由信息
     * @param gatewayRoute
     * @return
     */
    int update(GatewayRoute gatewayRoute);

    /**
     * 删除路由信息
     * @param id
     * @return
     */
    int delete(@Param("id") Long id);

}
