package com.qf.dao;

import com.qf.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Integer queryCount(Order order);

    Integer updateOrder(Order order);

    Integer addOrder(Order order);

    List<Order> findAll(Integer cusid);

    Integer orderDel(Integer id);

    Integer queryCountById(Integer id);

    Integer remove(Integer id);

    int delById(int id);
}
