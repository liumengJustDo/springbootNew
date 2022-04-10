package com.hue.jdk.service.impl;

import com.hue.jdk.bean.City;
import com.hue.jdk.mapper.CityMapper;
import com.hue.jdk.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname CityService
 * @Description TODO
 * @Date 2022/4/7 15:50
 * @Created by liumeng
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    public City getCityById(long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city){
         cityMapper.insert(city);
    }
}
