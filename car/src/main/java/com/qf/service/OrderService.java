package com.qf.service;

import com.qf.entity.Order;

import java.util.List;

public interface OrderService {

    //根据getid,backid,cid和total返回一个car
    List<Order> getAllOrder(Order order);
}
