package com.activity.server.mapper;

import com.activity.server.pojo.ActRoom;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.activity.server.pojo.ActRoom
*/
public interface ActRoomMapper {

    ActRoom getActRoom(@Param("name") String name);

    int getActRoomId(@Param("name") String name);
}
