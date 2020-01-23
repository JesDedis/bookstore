package com.qf.mapper;

import com.qf.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    //根据getid,backid,cid和total返回一个car
    List<Order> getAllOrder(Order order);
}
