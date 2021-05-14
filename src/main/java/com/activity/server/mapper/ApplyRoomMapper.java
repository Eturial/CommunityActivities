package com.activity.server.mapper;

import com.activity.server.pojo.ApplyRoom;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.activity.server.pojo.ApplyRoom
*/
public interface ApplyRoomMapper {
    // 传入活动室号与申请活动的对象
    void updateAccount(@Param("id") int id, @Param("applyRoom") ApplyRoom applyRoom);
}
