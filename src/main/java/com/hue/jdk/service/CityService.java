package com.hue.jdk.service;

import com.hue.jdk.bean.City;

/**
 * @Classname CityService
 * @Description TODO
 * @Date 2022/4/7 20:26
 * @Created by liumeng
 */
public interface CityService {
    public City getCityById(long id);

    public void saveCity(City city);
}
