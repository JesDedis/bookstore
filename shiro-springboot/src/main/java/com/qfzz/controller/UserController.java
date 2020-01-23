package com.qfzz.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toLogin")
    public String toLogin(){

        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model,boolean rememberMe) {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);

        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) { //用户名错误
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e){ //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/refuse")
    public String refuse(){

        return "refuse";
    }

    @RequestMapping("/add")
    public String add(){

        return "add";
    }

    @RequestMapping("/update")
    public String update(){

        return "update";
    }

    @RequestMapping("/delete")
    public String delete(){

        return "delete";
    }

    @RequestMapping("/query")
    public String query(){

        return "query";
    }
    /**
     * @RequestMapping("/logout")
     * public String loginout(){
     *     Subject subject = SecurityUtils.getSubject();
     *     subject.logout();
     *     return "redirect:login";   //这里重定向之后就会把修改和其他我们登陆进去后的操作删除记录
     * }
     */
}
