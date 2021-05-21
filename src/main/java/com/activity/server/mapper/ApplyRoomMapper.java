package com.activity.server.mapper;

import com.activity.server.pojo.ApplyRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.activity.server.pojo.ApplyRoom
*/
@Mapper
public interface ApplyRoomMapper {
    // 创建一条申请记录
    void addOne(@Param("applyRoom") ApplyRoom applyRoom);

    void updateCaption(@Param("applyRoom") ApplyRoom applyRoom);

    void updateStartTime(@Param("applyRoom") ApplyRoom applyRoom);

    void updateEndTime(@Param("applyRoom") ApplyRoom applyRoom);

    // 传入活动室号与申请活动的对象
//    void updateAccount(@Param("id") int id, @Param("applyRoom") ApplyRoom applyRoom);
}
