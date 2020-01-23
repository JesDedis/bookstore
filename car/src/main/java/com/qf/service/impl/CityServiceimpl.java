package com.qf.service.impl;

import com.qf.entity.City;
import com.qf.mapper.CityMapper;
import com.qf.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceimpl implements CityService {

    @Resource(name = "cityMapper")
    private CityMapper cityMapper;

    @Override
    public List<City> getCityByPid(Integer pid) {
        return cityMapper.getCityByPid(pid);
    }

    @Override
    public City findCityByGetId(Integer getid) {
        return cityMapper.findCityByGetId(getid);
    }

    @Override
    public City findCityByBackId(Integer backid) {
        return cityMapper.findCityByBackId(backid);
    }

}
