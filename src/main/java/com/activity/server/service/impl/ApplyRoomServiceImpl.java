package com.activity.server.service.impl;

import com.activity.server.mapper.ActRoomMapper;
import com.activity.server.mapper.ApplyRoomMapper;
import com.activity.server.mapper.UserMapper;
import com.activity.server.pojo.ApplyRoom;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.ApplyRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
*
*/
@Service
public class ApplyRoomServiceImpl implements ApplyRoomService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    ApplyRoomMapper applyRoomMapper;
    @Autowired
    ActRoomMapper actRoomMapper;

    @Override
    public RespBean addApply(String name, ApplyRoom applyRoom) {
        // 获取当前活动室状态信息
        String status = actRoomMapper.getActRoom(name).getStatus();
        int id = actRoomMapper.getActRoomId(name);
        if(status == "使用中")
            return RespBean.error("该活动室正在使用，创建失败");
        else{
            if(Objects.equals(actRoomMapper.getActRoom(name).getStatus(), userMapper.getAccount(applyRoom.getAccount()))) {
                applyRoomMapper.updateAccount(id,applyRoom);
            } else{
                return RespBean.error("活动号输入有误或不存在");
            }

            if(applyRoom.getCaption() != null) {
                applyRoomMapper.updateCaption();
            }
        }
    }
}
