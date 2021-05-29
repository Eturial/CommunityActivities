package com.activity.server.pojo;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

@Data
public class Dynamic {
    /**
     * 动态id 主键
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
     * 动态内容
     */
    private String content;

    /**
     * 发表时间
     */
    private String time;

    /**
     * 图片1 Url
     */
    private String url1;

    /**
     * 图片2 Url
     */
    private String url2;

    /**
     * 图片3 Url
     */
    private String url3;
//    private byte[] pic3;

    /**
     * 点赞个数
     */
    private Integer thumb;

    private String name;

    private Integer commentNum;

}