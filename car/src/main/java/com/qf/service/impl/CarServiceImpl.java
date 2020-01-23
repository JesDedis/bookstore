package com.qf.service.impl;

import com.qf.entity.Car;
import com.qf.mapper.CarMapper;
import com.qf.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Resource(name = "carMapper")
    private CarMapper carMapper;

    @Override
    public List<Car> queryAllByRent(Double price) {
        return carMapper.queryAllByRent(price);
    }

    @Override
    public List<Car> queryAllByNum(Integer number) {
        return carMapper.queryAllByNum(number);
    }

    @Override
    public Car findCarByGetId(Integer id) {
        return carMapper.findCarByGetId(id);
    }
}
