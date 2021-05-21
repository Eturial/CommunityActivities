package com.activity.server.mapper;

import com.activity.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.activity.server.pojo.User
*/
@Mapper
public interface UserMapper {

    User getUser(@Param("account") String account);

    void updateName(@Param("user") User user);

    void updateAccount(@Param("user") User user);

    void updateGender(@Param("user") User user);

    void updateCommunity(@Param("user") User user);
}
