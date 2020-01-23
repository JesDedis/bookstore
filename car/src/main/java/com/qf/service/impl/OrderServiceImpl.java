package com.qf.service.impl;

import com.qf.entity.Order;
import com.qf.mapper.OrderMapper;
import com.qf.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource(name = "orderMapper")
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrder(Order order) {
        return orderMapper.getAllOrder(order);
    }
}
