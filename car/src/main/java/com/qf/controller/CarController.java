package com.qf.controller;

import com.qf.entity.Car;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/price")
    @ResponseBody
    public List<Car> queryAllByRent(Double price){
        List<Car> cars = carService.queryAllByRent(price);
        if(cars != null){
            return cars;
        }else{
            return null;
        }
    }

    @RequestMapping("/number")
    @ResponseBody
    public List<Car> queryAllByNum(Integer number){
        List<Car> cars1 = carService.queryAllByNum(number);
        if(cars1 != null) {
            return cars1;
        }else{
            return null;
        }
    }

    @RequestMapping("/findcar")
    @ResponseBody
    public Car findCarByGetId(Integer cid){
        Car car = carService.findCarByGetId(cid);
        return car;
    }



}
