package com.qf.controller;

import com.qf.entity.LoginStatus;
import com.qf.entity.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpServletRequest request){
        User user1 = userService.login(user);
        LoginStatus loginStatus = new LoginStatus();
        if(user1 != null){
            loginStatus.setCode(1);
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public String Register(User user){
        userService.Register(user);
        return "1";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateByTel(String tel,Integer id){
        userService.updateByTel(tel,id);
        return "1";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateByEmail(String email,Integer id){
        userService.updateByEmail(email,id);
        return "1";
    }





}
