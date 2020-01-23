package com.qf.service;

import com.qf.entity.User;

public interface UserService {

    public User login(User user);

    public Integer Register(User user);

    //个人信息界面修改手机号
    Integer updateByTel(String tel,Integer id);

    //个人信息界面修改邮箱
    Integer updateByEmail(String email,Integer id);

    //个人界面修改密码
    Integer updatePWD(String password,Integer id);
}
