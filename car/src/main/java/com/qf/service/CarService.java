package com.qf.service;

import com.qf.entity.Car;

import java.util.List;

public interface CarService {

    //按照租金排序
    List<Car> queryAllByRent(Double price);

    //按照热度排序
    List<Car> queryAllByNum(Integer number);

    //根据id查询
    Car findCarByGetId(Integer id);
}
