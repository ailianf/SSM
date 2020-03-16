package com.ailian.dao;

import com.ailian.bean.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    /**
     * 添加产品信息
     * @param product
     */
    @Insert(value = {
            "insert into product(code, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus ) " +
                    "values(REPLACE(UUID(), '-', ''), #{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus}) "})
    void addProduct(Product product);

    /**
     * 修改product信息
     */
    @Update("update product set cityName = #{cityName}, departureTime = #{departureTime}, productPrice = #{productPrice}, productDesc = #{productDesc}, productStatus = #{productStatus} where code = #{code} ")
    void updateProduct(Product product);

    /**
     * 查询所有产品信息
     * @return
     */
    @Select(value = {"select * from product "})
    List<Product> findAll();

    /**
     * 根据code查询产品信息
     * @return
     */
    @Select(value = {"select * from product where code = #{code} "})
    Product findProductByCode(String code);
}
