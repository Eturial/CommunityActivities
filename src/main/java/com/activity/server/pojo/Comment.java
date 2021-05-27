package com.activity.server.pojo;

import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@Data
public class Comment {
    /**
     * 评论id 主键
     */
    private Integer commentId;

    /**
     * 动态id
     */
    private Integer dyId;

    /**
     * 用户活动号
     */
    private String account;

    /**
     * 头像Url
     */
    private String avatarUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date time;

}