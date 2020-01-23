package com.qfzz.controller;

import com.qfzz.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("查询单个用户")
    @GetMapping("/findById")
    public User findById(@RequestParam @ApiParam("用户ID") String uid){

        User user = new User();
        user.setUid(uid);
        user.setUsername("朴智妍");
        user.setPassword("0000");

        return user;
    }

    @ApiOperation("查询所有用户")
    @PostMapping("/findAll")
    public List<User> findAll(){

        User user1 = new User();
        user1.setUid("1001");
        user1.setUsername("李居丽");
        user1.setPassword("0000");

        User user2 = new User();
        user2.setUid("1002");
        user2.setUsername("金泰妍");
        user2.setPassword("123");

        User user3 = new User();
        user3.setUid("1003");
        user3.setUsername("徐珠贤");
        user3.setPassword("456");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

}
