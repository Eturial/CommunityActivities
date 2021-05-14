package com.activity.server.service;

import com.activity.server.pojo.ApplyRoom;
import com.activity.server.pojo.RespBean;

/**
*
*/
public interface ApplyRoomService {

    RespBean addApply(String name, ApplyRoom applyRoom);
}
