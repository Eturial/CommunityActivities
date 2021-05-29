package com.activity.server.controller;

import com.activity.server.pojo.Comment;
import com.activity.server.pojo.Dynamic;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.CommentService;
import com.activity.server.service.DynamicService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping(value = "/updateComment")
    @ResponseBody
    // 发表一条评论
    public RespBean updateDynamic(@RequestBody JSONObject object) {

        Comment comment = new Comment();

        comment.setAccount(object.getString("account"));
        comment.setAvatarUrl(object.getString("avatarUrl"));
        comment.setContent(object.getString("content"));
        comment.setTime(object.getString("time"));


        Dynamic dynamic = new Dynamic();

        dynamic.setDyId(object.getInteger("dyId"));



        return commentService.updateComment(comment, dynamic);
    }

    @GetMapping(value = "/getAllComment")
    @ResponseBody
    // 查看一条动态的全部评论
    public List<Comment> getAllComment(@RequestBody JSONObject object) {
        Dynamic dynamic = new Dynamic();
        dynamic.setDyId(object.getInteger("dyId"));
        return commentService.getAllComment(dynamic);
    }

    // 查看一个用户的相关消息
    @GetMapping(value = "/getMessage")
    @ResponseBody
    public List<Comment> getUserMessage(@RequestBody JSONObject object) {

        Dynamic dynamic = new Dynamic();
        dynamic.setAccount(object.getString("account"));

        return commentService.getUserMessage(dynamic);
    }
}
