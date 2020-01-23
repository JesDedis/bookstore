package com.qf.mapper;

import com.qf.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarMapper {

    //按照租金排序
    List<Car> queryAllByRent(Double price);

    //按照热度排序
    List<Car> queryAllByNum(Integer number);

    //根据id查询
    Car findCarByGetId(Integer id);
}
