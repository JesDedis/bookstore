package com.qf.mapper;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    //登陆
    User login(User user);

    //注册
    Integer Register(User user);

    //个人信息界面修改手机号
    Integer updateByTel(String tel,Integer id);

    //个人信息界面修改邮箱
    Integer updateByEmail(String email,Integer id);

    //个人界面修改密码
    Integer updatePWD(String password,Integer id);
}
