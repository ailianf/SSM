package com.ailian.service;

import com.ailian.bean.Product;

import java.text.ParseException;
import java.util.List;

public interface IProductService {

    /**
     * 添加产品信息
     * @param product
     */
    void addProduct(Product product) throws ParseException;

    /**
     * 查询所有产品信息
     * @return
     */
    List<Product> findAll();

    /**
     * 修改product信息
     */
    void updateProduct(Product product);

    /**
     * 查询所有产品信息，使用mybatis的pageHelper进行分页处理
     * @return
     */
    List<Product> findAll(int page, int pageSize);

    /**
     * 根据code查询产品信息
     * @return
     */
    Product findProductByCode(String code);
}
