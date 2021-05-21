package com.activity.server.controller;

import com.activity.server.pojo.RespBean;
import com.activity.server.pojo.User;
import com.activity.server.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/getUser")
    @ResponseBody
    public User getUser(@RequestBody JSONObject object) {
        User user = userService.getUser(object.getString("account"));
        return user;
    }

    @GetMapping(value = "/getUserAccount")
    @ResponseBody
    public String getAccount(@RequestBody JSONObject object) {
        User user = userService.getUser(object.getString("account"));
        return user.getAccount();
    }

    @PostMapping(value = "/updateUser")
    @ResponseBody
    public RespBean updateUser(@RequestBody JSONObject object) {
        User user = new User();
        user.setAccount(object.getString("account"));
        user.setName(object.getString("name"));
        user.setGender(object.getString("gender"));
        user.setCommunity(object.getString("community"));

        return userService.updateUser(user);
    }
}
