package com.activity.server.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * id,自增,主键
     */
    private Integer userId;

    /**
     * 用户活动号（自定义一个11位纯数字账号）
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别（男 or 女）
     */
    private String gender;

    /**
     * 社区名
     */
    private String community;

    /**
     * 权限（0表示普通用户，1表示管理员）
     */
    private String permission;

}