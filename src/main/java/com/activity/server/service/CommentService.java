package com.activity.server.service;

import com.activity.server.pojo.Comment;
import com.activity.server.pojo.Dynamic;
import com.activity.server.pojo.RespBean;

import java.util.List;

/**
*
*/
public interface CommentService {

    RespBean updateComment(Comment comment, Dynamic dynamic);

    List<Comment> getAllComment();
}
