package com.ailian.service;

import com.ailian.bean.Traveller;

import java.util.List;

public interface ITravellerService {

    /**
     * 查询所有旅客信息
     * @return
     */
    List<Traveller> findAll();

    /**
     * 根据旅客的code信息查询详细信息
     * @param code
     * @return
     */
    Traveller findTravellerByCode(String code);
}
