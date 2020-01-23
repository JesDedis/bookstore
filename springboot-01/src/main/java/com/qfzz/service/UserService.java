package com.qfzz.service;

import com.qfzz.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String uid);
}
