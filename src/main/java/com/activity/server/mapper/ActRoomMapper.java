package com.activity.server.mapper;

import com.activity.server.pojo.ActRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ActRoomMapper {

    ActRoom getActRoom(@Param("name") String name);

    void updateStatus(@Param("name") String name);
}
