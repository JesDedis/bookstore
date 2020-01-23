package com.qf.controller;

import com.qf.entity.City;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired//Controller层里调用的是Service层的方法
    private CityService cityService;

    @RequestMapping("/select")
    @ResponseBody//返回值是啥就返回的啥
    public List<City> getCityById(Integer pid){
        List<City> cities = cityService.getCityByPid(pid);
        return cities;
    }

    @RequestMapping("/citys")
    @ResponseBody
    public List<City> getAndBackId(Integer getid,Integer backid){
        //创建一个集合，把查到的getid，backid放进去，然后返回
        List<City> cities = new ArrayList<>();
        City cityByGetId = cityService.findCityByGetId(getid);
        City cityByBackId = cityService.findCityByBackId(backid);
        cities.add(cityByGetId);
        cities.add(cityByBackId);
        return cities;
    }
    
}