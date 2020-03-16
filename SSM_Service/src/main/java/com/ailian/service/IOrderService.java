package com.ailian.service;

import com.ailian.bean.Order;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();

    List<Order> findOrderAndProduct();

    /**
     * 使用mybatis的pagehelper实现分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<Order> findOrderAndProduct(int page, int pageSize);

    /**
     * 根据order的code查询相关的详细信息
     */
    Order findOrderByCode(String code);
}
