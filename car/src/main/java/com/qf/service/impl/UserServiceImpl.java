package com.qf.service.impl;

import com.qf.entity.User;
import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    //登陆
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    //注册
    @Override
    public Integer Register(User user) {
        return userMapper.Register(user);
    }

    //修改手机号
    @Override
    public Integer updateByTel(String tel,Integer id) {
        return userMapper.updateByTel(tel,id);
    }

    //修改邮箱
    @Override
    public Integer updateByEmail(String email,Integer id) {
        return userMapper.updateByEmail(email,id);
    }

    //修改密码
    @Override
    public Integer updatePWD(String password, Integer id) {
        return userMapper.updatePWD(password,id);
    }

}
