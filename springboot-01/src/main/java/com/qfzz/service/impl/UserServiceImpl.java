package com.qfzz.service.impl;

import com.qfzz.entity.User;
import com.qfzz.mapper.UserMapper;
import com.qfzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(String uid) {
        return userMapper.findById(uid);
    }
}
