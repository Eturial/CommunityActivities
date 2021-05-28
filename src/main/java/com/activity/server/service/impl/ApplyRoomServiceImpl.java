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
//    public RespBean addApply(ApplyRoom applyRoom) {
    public RespBean addApply(String name, ApplyRoom applyRoom) {
        // 获取当前活动室状态信息
        String status = actRoomMapper.getActRoom(name).getStatus();
        if(status != null) {
            if(Objects.equals("使用中",status))
                return RespBean.error("该活动室正在使用，创建失败");
        }
//        System.out.println(status);
        else {
             // 判断活动号是否有效
            if(userMapper.getUser(applyRoom.getAccount()) != null) {
                applyRoomMapper.addOne(applyRoom);
            } else{
                return RespBean.error("活动号输入有误或不存在");
            }
            // 判断描述是否为空
            if(applyRoom.getCaption() != null) {
                applyRoomMapper.updateCaption(applyRoom);
            } else{
                return RespBean.error("描述不能为空!");
            }
            // 判断时间
            if(applyRoom.getCaption() != null) {
                applyRoomMapper.updateStartTime(applyRoom);
            } else{
                return RespBean.error("起止时间不能为空!");
            }
            if(applyRoom.getCaption() != null) {
                applyRoomMapper.updateEndTime(applyRoom);
            } else{
                return RespBean.error("起止时间不能为空!");
            }
        }
        actRoomMapper.updateStatus(name);
        return RespBean.success("申请成功！");
    }
}
