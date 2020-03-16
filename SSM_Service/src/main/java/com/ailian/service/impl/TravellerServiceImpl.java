package com.ailian.service.impl;

import com.ailian.bean.Traveller;
import com.ailian.dao.ITravellerDao;
import com.ailian.service.ITravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TravellerServiceImpl implements ITravellerService {

    @Autowired
    private ITravellerDao travellerDao;

    public List<Traveller> findAll() {
        return travellerDao.findAll();
    }

    public Traveller findTravellerByCode(String code) {
        return travellerDao.findTravellerByCode(code);
    }
}
