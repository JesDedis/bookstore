package com.qf.service;

import com.qf.entity.City;

import java.util.List;

public interface CityService {

    List<City> getCityByPid(Integer pid);

    //通过getid查询
    public City findCityByGetId(Integer getid);

    //通过BackId查询
    public City findCityByBackId(Integer backid);
}
