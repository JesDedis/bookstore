package com.qf.mapper;

import com.qf.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityMapper {

    //通过id查询城市
    List<City> getCityByPid(Integer pid);

    //通过getid查询
    public City findCityByGetId(Integer getid);

    //通过BackId查询
    public City findCityByBackId(Integer backid);
}
