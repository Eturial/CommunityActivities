package com.activity.server.pojo;

import lombok.Data;

/**
 * 
 * @TableName act_room
 */
@Data
public class ActRoom {
    /**
     * 活动室编号,自增,主键
     */
    private Integer roomId;

    /**
     * 活动室名
     */
    private String name;

    /**
     * 状态信息
     */
    private String status;

}