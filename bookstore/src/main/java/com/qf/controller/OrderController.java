package com.qf.controller;

import com.qf.entity.Order;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll")
    public String findAll(Integer cusid, Model model) {
        List<Order> orders = orderService.findAll(cusid);
        model.addAttribute("orderList",orders);
        return "before/orderList";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Order order) {
        Integer count = orderService.queryCount(order);
        if (count>0) {
            orderService.updateOrder(order);
        }else {
            orderService.addOrder(order);
        }
        return "success";
    }

    @RequestMapping("/orderDel")
    @ResponseBody
    public String orderDel(Integer id) {
        System.out.println(id);
        Integer flag = orderService.orderDel(id);
        return "success";
    }

    @RequestMapping("/delAll")
    public String delAll(int[] ids) {
        for (int id : ids) {
            int flag = orderService.delById(id);
        }
        return "redirect:book/list";
    }
}
