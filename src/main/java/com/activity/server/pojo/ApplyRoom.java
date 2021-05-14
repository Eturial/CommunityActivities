package com.activity.server.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName apply_room
 */
@Data
public class ApplyRoom implements Serializable {
    /**
     * 申请动室编号,自增,外键
     */
    private Integer roomId;

    /**
     * 用户活动号,外键
     */
    private String account;

    /**
     * 描述信息
     */
    private String caption;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}