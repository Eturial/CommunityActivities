package com.activity.server.controller;
import com.activity.server.pojo.ActRoom;
import com.activity.server.pojo.ApplyRoom;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.ActRoomService;
import com.activity.server.service.ApplyRoomService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/apply")
public class ApplyController {
    @Autowired
    ApplyRoomService applyRoomService;

    @PostMapping(value = "/addApply")
    @ResponseBody
    public RespBean addApply(@RequestBody JSONObject object) {
//    public RespBean addApply(String name,@RequestBody JSONObject object) {

        ApplyRoom applyRoom = new ApplyRoom();

        String name = object.getString("name");

        applyRoom.setAccount(object.getString("account"));
        applyRoom.setCaption(object.getString("caption"));
        applyRoom.setStartTime(object.getDate("startTime"));
        applyRoom.setEndTime(object.getDate("endTime"));
//        return applyRoomService.addApply(applyRoom);
        return applyRoomService.addApply(name,applyRoom);
    }

}
