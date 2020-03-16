package com.ailian.dao;

import com.ailian.bean.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellerDao {

    /**
     * 查询所有旅客信息
     * @return
     */
    @Select(value = {"select * from traveller "})
    List<Traveller> findAll();

    /**
     * 根据旅客的code信息查询详细信息
     * @param code
     * @return
     */
    @Select(value = {"select * from traveller where code = #{code} "})
    Traveller findTravellerByCode(String code);

    /**
     * 根据旅客的orderCode信息查询详细信息
     * @param orderCode
     * @return
     */
    @Select(value = {"SELECT * FROM traveller " +
            "WHERE CODE IN( " +
            "SELECT travellerCode FROM order_traveller WHERE orderCode = #{orderCode} " +
            ") "})
    Traveller findTravellerByOrderCode(String orderCode);
}
