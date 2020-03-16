package com.ailian.service.impl;

import com.ailian.bean.Order;
import com.ailian.dao.IOrderDao;
import com.ailian.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao ordersDao;

    public List<Order> findAll() {
        return ordersDao.findAll();
    }

    public List<Order> findOrderAndProduct() {
        return ordersDao.findOrderAndProduct();
    }

    /**
     * 使用mybatis的pagehelper实现分页查询
     * @param page
     * @param pageSize
     * @return
     */
    public List<Order> findOrderAndProduct(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findOrderAndProduct();
    }

    public Order findOrderByCode(String code) {
        return ordersDao.findOrderByCode(code);
    }


}
