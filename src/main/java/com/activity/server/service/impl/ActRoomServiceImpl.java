package com.activity.server.service.impl;

import com.activity.server.mapper.ActRoomMapper;
import com.activity.server.pojo.ActRoom;
import com.activity.server.service.ActRoomService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class ActRoomServiceImpl implements ActRoomService{
    @Autowired
    ActRoomMapper actRoomMapper;

//    @Override
//    public ActRoom getActRoom(String name) {
//        return actRoomMapper.getActRoom(name);
//    }
}
