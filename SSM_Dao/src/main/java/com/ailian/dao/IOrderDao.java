package com.ailian.dao;

import com.ailian.bean.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {

    /**
     * 查询所有的订单信息
     *
     * @return
     */
    @Select(value = {"select * from orders "})
    List<Order> findAll();

    /**
     * 查询所有的订单信息
     *
     * @return
     */
    @Select(value = {"select * from orders "})
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "orderNum", column = "orderNum"),
                    @Result(property = "orderTime", column = "orderTime"),
                    @Result(property = "peopleCount", column = "peopleCount"),
                    @Result(property = "orderDesc", column = "orderDesc"),
                    @Result(property = "payType", column = "payType"),
                    @Result(property = "orderStatus", column = "orderStatus"),
                    @Result(property = "member", column = "memberCode",
                            one = @One(select = "com.ailian.dao.IMemberDao.findMemberByCode", fetchType = FetchType.EAGER)),
                    @Result(property = "product", column = "productCode",
                            one = @One(select = "com.ailian.dao.IProductDao.findProductByCode", fetchType = FetchType.EAGER))
            }
    )
    List<Order> findOrderAndProduct();

    /**
     * 根据order的code查询相关的详细信息
     */
    @Select("select * from orders where code = #{code} ")
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "orderNum", column = "orderNum"),
                    @Result(property = "orderTime", column = "orderTime"),
                    @Result(property = "peopleCount", column = "peopleCount"),
                    @Result(property = "orderDesc", column = "orderDesc"),
                    @Result(property = "payType", column = "payType"),
                    @Result(property = "orderStatus", column = "orderStatus"),
                    @Result(property = "member", column = "memberCode",
                            one = @One(select = "com.ailian.dao.IMemberDao.findMemberByCode", fetchType = FetchType.EAGER)),
                    @Result(property = "product", column = "productCode",
                            one = @One(select = "com.ailian.dao.IProductDao.findProductByCode", fetchType = FetchType.EAGER)),
                    @Result(property = "travellers", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.ITravellerDao.findTravellerByOrderCode", fetchType = FetchType.LAZY))
            }
    )
    Order findOrderByCode(String code);
}
