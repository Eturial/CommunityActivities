package com.activity.server.service.impl;

import com.activity.server.mapper.UserMapper;
import com.activity.server.pojo.RespBean;
import com.activity.server.pojo.User;
import com.activity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;


    @Override
    public RespBean updateUser(User user) {

        if(userMapper.getUser(user.getAccount()) != null) {
            return RespBean.error("该活动号已被使用");
        } else {
            userMapper.updateAccount(user);
             //判断昵称
            if(user.getName() != null) {
                userMapper.updateName(user);
            }
            // 判断社区
            if(user.getCommunity() != null) {
                userMapper.updateCommunity(user);
            }
            // 判断性别
            if(Objects.equals("男", user.getGender()) || Objects.equals("女", user.getGender())) {
                userMapper.updateGender(user);
            } else {
                return RespBean.error("性别输入有误!");
            }
        }
        return RespBean.success("修改成功！");
    }

    @Override
    public User getUser(String account) {
//        System.out.println(userMapper.getUser(account).toString());
        return userMapper.getUser(account);
    }
}
