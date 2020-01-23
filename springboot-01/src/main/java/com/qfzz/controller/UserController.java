package com.qfzz.controller;

import com.qfzz.entity.User;
import com.qfzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){

        System.out.println("findAll");

        return userService.findAll();
    }

    @RequestMapping("/go")
    public String go(String username, Model model) {

        model.addAttribute("username",username);

        return "main";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        model.addAttribute("hello","hello Thymeleaf");

        List<User> users = userService.findAll();

        model.addAttribute("users",users);

        return "list";
    }

    @RequestMapping("/findById")
    public String findById(Model model,String uid) {

        User user = userService.findById(uid);

        model.addAttribute("user",user);

        return "queryOne";
    }

}
