package com.qf.controller;

import com.qf.entity.Order;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Order> getAllOrder(Order order){
        List<Order> order1 = orderService.getAllOrder(order);
        return order1;
    }
}
