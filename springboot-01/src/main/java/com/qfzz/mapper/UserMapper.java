package com.qfzz.mapper;

import com.qfzz.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(String uid);
}
