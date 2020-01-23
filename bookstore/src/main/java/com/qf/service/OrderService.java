package com.qf.service;

import com.qf.entity.Order;

import java.util.List;

public interface OrderService {

    Integer queryCount(Order order);

    Integer updateOrder(Order order);

    Integer addOrder(Order order);

    List<Order> findAll(Integer cusid);

    Integer orderDel(Integer id);

    Integer queryCountById(Integer id);

    Integer remove(Integer id);

    int delById(int id);
}
