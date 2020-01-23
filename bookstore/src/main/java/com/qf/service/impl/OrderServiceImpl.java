package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Integer queryCount(Order order) {
        return orderDao.queryCount(order);
    }

    @Override
    public Integer updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public Integer addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public List<Order> findAll(Integer cusid) {
        return orderDao.findAll(cusid);
    }

    @Override
    public Integer orderDel(Integer id) {
        return orderDao.orderDel(id);
    }

    @Override
    public Integer queryCountById(Integer id) {
        return orderDao.queryCountById(id);
    }

    @Override
    public Integer remove(Integer id) {
        return orderDao.remove(id);
    }

    @Override
    public int delById(int id) {
        return orderDao.delById(id);
    }
}
