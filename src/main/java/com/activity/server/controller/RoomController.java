package com.activity.server.controller;

import com.activity.server.pojo.ActRoom;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.ActRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "room")
public class RoomController {
    @Autowired
    ActRoomService actRoomService;

    @GetMapping("/getStatus")
    @ResponseBody
    // 返回一个获取到的状态信息
    public RespBean getRoomStatusByName(String name) {
        // 获取活动室状态
        ActRoom actRoom = actRoomService.getActRoom(name);
        String status = actRoom.getStatus();
        return RespBean.success("当前活动室"+getRoomStatusByName(name));
    }
}
