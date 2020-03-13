package com.example.project.dao;

import com.example.project.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: tanxx
 * @create: 2020-03-12 09:37
 * @description:
 **/
@Mapper
public interface PaymentDao {

    /**
     * 保存操作
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查询
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
