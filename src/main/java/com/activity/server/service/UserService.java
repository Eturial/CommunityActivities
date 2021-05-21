package com.activity.server.service;

import com.activity.server.pojo.RespBean;
import com.activity.server.pojo.User;

public interface UserService {

    RespBean updateUser(User user);

    User getUser(String account);
}
